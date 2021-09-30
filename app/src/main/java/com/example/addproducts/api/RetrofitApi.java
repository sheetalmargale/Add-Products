package com.example.addproducts.api;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApi {
    public static String BASE_URL = "https://my-json-server.typicode.com/nancymadan/assignment/";
    private static RetrofitApi mInstance;
    private Retrofit retrofit;

    private RetrofitApi()
    {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    public static synchronized RetrofitApi getInstance()
    {
        if (mInstance == null)
            mInstance = new RetrofitApi();
        return mInstance;
    }

    public ApiService getApi()
    {
        return retrofit.create(ApiService.class);
    }


}
