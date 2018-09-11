package com.hacaller.lighthousejourney;

import android.os.AsyncTask;
import android.util.Log;

import io.ipgeolocation.api.Geolocation;
import io.ipgeolocation.api.GeolocationParams;
import io.ipgeolocation.api.IPGeolocationAPI;

/**
 * Created by Herbert Caller on 11/09/2018.
 */
public class IPGeolocationAsyncTask extends AsyncTask<Void, Void,Geolocation> {

    GeolocationResult geolocationResult;

    @Override
    protected Geolocation doInBackground(Void... voids) {
        IPGeolocationAPI api = new IPGeolocationAPI("43c6ca713f7644a0bd5a5d5dbe680971");

        //GeolocationParams geoParams = new GeolocationParams();
        //geoParams.setIp(strings[0]);
        //Geolocation geolocation = api.getGeolocation(geoParams);
        Geolocation geolocation = api.getGeolocation();

        if(geolocation.getStatus() == 200) {
            Log.i(getClass().getCanonicalName(),geolocation.getCountryName());
        } else {
            Log.i(getClass().getCanonicalName(),geolocation.getMessage());
        }
        return geolocation;
    }

    @Override
    protected void onPostExecute(Geolocation geolocation) {
        super.onPostExecute(geolocation);
        if (geolocationResult != null)
            geolocationResult.showGeolocationResult(geolocation);
    }

    public interface GeolocationResult{
        void showGeolocationResult(Geolocation geolocation);
    }

    public void setGeolocationResult(GeolocationResult geolocationResult) {
        this.geolocationResult = geolocationResult;
    }
}
