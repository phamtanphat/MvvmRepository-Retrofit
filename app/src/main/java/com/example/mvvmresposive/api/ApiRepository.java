package com.example.mvvmresposive.api;

import com.example.mvvmresposive.api.response.WordResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiRepository {
    @GET("word")
    Call<WordResponse> getWord();

    @DELETE("word/{id}")
    Call<WordResponse> delete(@Path("id") String id);
}
