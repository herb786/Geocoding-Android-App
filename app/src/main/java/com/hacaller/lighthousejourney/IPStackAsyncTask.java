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
public class IPStackAsyncTask extends AsyncTask<Void,Void,IPStackLocation> {

    IpStackResult ipStackResult;

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://api.ipstack.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public interface IPStackService {
        @GET("{ipAddress}?access_key=7f0244fe3dd274c93ec459665adbd1bc")
        Call<IPStackLocation> getIPStack(@Path("ipAddress") String ipAddress);
    }

    public interface MachineIPStackService {
        @GET("/check?access_key=7f0244fe3dd274c93ec459665adbd1bc")
        Call<IPStackLocation> getMachineIPStack();
    }

    MachineIPStackService service = retrofit.create(MachineIPStackService.class);

    @Override
    protected IPStackLocation doInBackground(Void... voids) {
        try {
            IPStackLocation stackLocation = service.getMachineIPStack().execute().body();
            return stackLocation;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(IPStackLocation ipStackLocation) {
        super.onPostExecute(ipStackLocation);
        if (ipStackResult != null)
            ipStackResult.showIpStackResult(ipStackLocation);
    }


    public interface IpStackResult {
        void showIpStackResult(IPStackLocation ipStackLocation);
    }

    public void setIpStackResult(IpStackResult ipStackResult) {
        this.ipStackResult = ipStackResult;
    }
}
