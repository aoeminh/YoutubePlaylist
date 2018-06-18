package com.example.apple.youtubeplaylist;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private Retrofit retrofit  =null;

    public static Retrofit getRetrofiClient(String baseURL){

        Retrofit retrofit = new Retrofit.Builder()
                                .baseUrl(baseURL)
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();
        return retrofit;
    }
}
