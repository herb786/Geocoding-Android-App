# Geolocalización con Android y Google Places

Este aplicativo será un punto de partida para integrar servicos de geolocalización y encontrar la ubicación del usuario, operador, vehículo o portador. Este tipo de información puder ser crucial para brindar primeros auxilios o ayudas en caso de siniestro

El aplicativo simplemente mostrará la ubicación del usuario usando dos métodos de geolocalización. El primero hará uso del servicio Google Places y el otro servicio alternativo de localización por IP. En ambos casos la ubicación geocodificada en coordenadas de longitud y latitud es revertida para retornar una dirección humanamente significativa y reconocible.

## Google Places API
Antes de empezar debemos tener una cuenta en GCP (Gooogle Cloud Platform), y generar una llave de autorización para acceder a esta API.

Google Places permite consultar detalles acerca de lugares y establecimientos como teléfonos, direcciones, calificación. También podemos encontrar el lugar donde nos encontramos, sus coordenadas y más.

En modo de desarrollo debemos usar el certificado cifrado SHA1 que resulta de este comando

`keytool -list -v -keystore ~/.android/debug.keystore -alias androiddebugkey -storepass android -keypass android`

En el fichero **manifest.xml** debemos activar los permisos de localización e internet ay agregar nuestra llave de autorización
```java
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>
<uses-permission android:name="android.permission.INTERNET"/>
...
<meta-data android:name="com.google.android.geo.API_KEY"
         android:value="API_KEY"/>
...
```
Agregamos la siguiente dependencia en el fichero gradle del aplicativo

`implementation 'com.google.android.gms:play-services-places:15.0.1'`

Esta pedazo de código hara una petición a Google Places retornando todos los detalles acerca de la ubicación actual

```java
private PlaceDetectionClient mPlaceDetectionClient;
...
mPlaceDetectionClient = Places.getPlaceDetectionClient(this, null);
...
Luego podemos recibir el resultado usando este código


Task<PlaceLikelihoodBufferResponse> placeResult = mPlaceDetectionClient.getCurrentPlace(null);
placeResult.addOnCompleteListener(new OnCompleteListener<PlaceLikelihoodBufferResponse>() {
    @Override
    public void onComplete(@NonNull Task<PlaceLikelihoodBufferResponse> task) {
        PlaceLikelihoodBufferResponse likelyPlaces = task.getResult();
        PlaceLikelihood placeLikelihood = likelyPlaces.get(0);
        Place place = placeLikelihood.getPlace();
        Log.d("READABLE ADDRESS",place.getAddress());
        likelyPlaces.release();
    }
});
```

## Geolocalización usando la dirección IP
En este caso debemos encontrar un proveedor apropiado que nos permitas consumir el servicio usando el protocolo HTTP. En este caso el proveedor es IP Geolocation API. Debemos tener en cuenta que su uso libre tiene una cuota limitada de consultas.

Agregamos una nueva dependencia en el fichero gradle

`implementation 'io.ipgeolocation:ipgeolocation:1.0.2'`

Este pedazo de código retornará la ubicación. El nivel de precisión dependerá del proveedor

```java
public class IPGeolocationAsyncTask extends AsyncTask<Void, Void,Void> {

    GeolocationResult geolocationResult;

    @Override
    protected Geolocation doInBackground(Void... voids) {
        IPGeolocationAPI api = new IPGeolocationAPI("API_KEY");
        Geolocation geolocation = api.getGeolocation();

        if(geolocation.getStatus() == 200) {
            Log.i(getClass().getCanonicalName(),geolocation.getCity());
        } else {
            Log.i(getClass().getCanonicalName(),geolocation.getMessage());
        }
        return geolocation;
    }
}
```

![alt text](https://s3-us-west-2.amazonaws.com/py4hacaller/device-2018-09-11.png)

### Referencias
1. https://developers.google.com/places/android-sdk/current-place
2. https://developer.android.com/training/location/
3. https://developers.google.com/maps/documentation/geocoding/start
4. https://developer.android.com/reference/android/location/Geocoder
5. https://developers.google.com/android/guides/setup
6. https://ipstack.com
7. http://ip-api.com
8. https://ipgeolocation.io
9. https://en.wikipedia.org/wiki/Reverse_geocoding
10. D Abernathy. "Chapter: The Power of Where". Using Geodata and Geolocation in the Social Sciences.
11. JL Awange, JBK Kiema. "Chapter: Geodata and Geoinformatics". Environmental Geoinformatics.