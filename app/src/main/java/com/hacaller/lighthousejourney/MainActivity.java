package com.hacaller.lighthousejourney;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.google.android.gms.location.places.GeoDataClient;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.PlaceDetectionClient;
import com.google.android.gms.location.places.PlaceLikelihood;
import com.google.android.gms.location.places.PlaceLikelihoodBufferResponse;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import io.ipgeolocation.api.Geolocation;

public class MainActivity extends AppCompatActivity
        implements IPGeolocationAsyncTask.GeolocationResult{

    private GeoDataClient mGeoDataClient;
    private PlaceDetectionClient mPlaceDetectionClient;
    TextView placeCoordinates;
    TextView resultIpGeolocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        placeCoordinates = findViewById(R.id.placeCoordinates);
        resultIpGeolocation = findViewById(R.id.resultIpGeolocation);

        IPGeolocationAsyncTask asyncTask1 = new IPGeolocationAsyncTask();
        asyncTask1.setGeolocationResult(this);
        asyncTask1.execute();


        // Construct a GeoDataClient.
        mGeoDataClient = Places.getGeoDataClient(this, null);

        // Construct a PlaceDetectionClient.
        mPlaceDetectionClient = Places.getPlaceDetectionClient(this, null);

        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION},999);
        } else {
            getLocation();
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        getLocation();
    }

    private void getLocation(){
        @SuppressLint("MissingPermission")
        Task<PlaceLikelihoodBufferResponse> placeResult = mPlaceDetectionClient.getCurrentPlace(null);
        placeResult.addOnCompleteListener(new OnCompleteListener<PlaceLikelihoodBufferResponse>() {
            @Override
            public void onComplete(@NonNull Task<PlaceLikelihoodBufferResponse> task) {
                PlaceLikelihoodBufferResponse likelyPlaces = task.getResult();
                PlaceLikelihood placeLikelihood = likelyPlaces.get(1);
                Place place = placeLikelihood.getPlace();
                placeCoordinates.setText(String.format("Your current position:\n%s\nLatitude: %f\nLongitude: %f\n",
                        place.getAddress(),
                        place.getLatLng().latitude,
                        place.getLatLng().longitude));
                likelyPlaces.release();

            }
        });
    }

    @Override
    public void showGeolocationResult(Geolocation geolocation) {
        if (geolocation != null) {
            resultIpGeolocation.setText(String.format("Fire stations in:\n%s", geolocation.getCity()));
        }
    }

}
