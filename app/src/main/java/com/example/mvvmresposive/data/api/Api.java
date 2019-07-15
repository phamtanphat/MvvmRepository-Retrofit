package com.example.mvvmresposive.data.api;

import com.example.mvvmresposive.BuildConfig;
import com.example.mvvmresposive.data.service.Dataapi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api {
    private static Retrofit retrofit = null;

    private static Retrofit getInstace(String base_url){
        if (retrofit == null){
            Gson gson = new GsonBuilder().disableHtmlEscaping().create();
            retrofit = new Retrofit.Builder()
                        .baseUrl(base_url)
                        .client(makeHttpClient())
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build();
            return retrofit;
        }
        return retrofit;
    }
    private static OkHttpClient makeHttpClient(){
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder()
                                .connectTimeout(30, TimeUnit.SECONDS)
                                .writeTimeout(30,TimeUnit.SECONDS)
                                .readTimeout(30,TimeUnit.SECONDS)
                                .cache(null);

        if (BuildConfig.DEBUG){
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
            okHttpClient.addInterceptor(loggingInterceptor);
        }
        return okHttpClient.build();
    }
    public static Dataapi createRequest(){
        return Api.getInstace("https://server2301.herokuapp.com/").create(Dataapi.class);
    }

}
