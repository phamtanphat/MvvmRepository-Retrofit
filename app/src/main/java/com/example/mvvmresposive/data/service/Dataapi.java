package com.example.mvvmresposive.data.service;

import android.database.Observable;

import com.example.mvvmresposive.data.model.Tuvungapi;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Dataapi {
    @GET("word")
    Call<Tuvungapi> getWord();
}
