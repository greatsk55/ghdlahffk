package kr.badream.convenience.Helper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by user on 16. 6. 12.
 */
public class Helper_server {
    public static final String BASE_URL = "http://52.78.10.188/";
    public static final String URL = "https://api.github.com/";

    public static ApiInterface getInterfaceService() {/*
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Helper_server.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();*/
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(LenientGsonConverterFactory.create())
                .build();

        final ApiInterface mInterfaceService = retrofit.create(ApiInterface.class);
        return mInterfaceService;
    }

    public static ApiInterface getService(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Helper_server.URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final ApiInterface mInterfaceService = retrofit.create(ApiInterface.class);
        return mInterfaceService;
    }
}