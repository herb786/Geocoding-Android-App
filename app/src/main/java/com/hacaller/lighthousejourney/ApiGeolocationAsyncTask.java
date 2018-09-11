package com.hacaller.lighthousejourney;

import android.os.AsyncTask;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Herbert Caller on 11/09/2018.
 */
public class ApiGeolocationAsyncTask extends AsyncTask<Void,Void,ResponseGeolocation> {

    ApiGeolocationResult geolocationResult;

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://ip-api.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public interface IPGeolocationService {
        @GET("json/{ipAddress}")
        Call<ResponseGeolocation> getGeolocation(@Path("ipAddress") String ipAddress);
    }

    public interface MachineIPGeolocationService {
        @GET("json")
        Call<ResponseGeolocation> getMachineGeolocation();
    }

    MachineIPGeolocationService service = retrofit.create(MachineIPGeolocationService.class);

    @Override
    protected ResponseGeolocation doInBackground(Void... voids) {
        try {
            ResponseGeolocation geolocation = service.getMachineGeolocation().execute().body();
            return geolocation;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(ResponseGeolocation responseGeolocation) {
        super.onPostExecute(responseGeolocation);
        if (geolocationResult != null)
            geolocationResult.showGeolocationResult(responseGeolocation);
    }


    public interface ApiGeolocationResult {
        void showGeolocationResult(ResponseGeolocation responseGeolocation);
    }

    public void setGeolocationResult(ApiGeolocationResult geolocationResult) {
        this.geolocationResult = geolocationResult;
    }
}
