package com.example.mvvmresposive.data.repositories;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import com.example.mvvmresposive.data.api.Api;
import com.example.mvvmresposive.data.model.Tuvungapi;
import com.example.mvvmresposive.data.model.Wordapi;
import com.example.mvvmresposive.data.service.Dataapi;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WordRepositoryInpl implements WordRepository{
    private MutableLiveData<Tuvungapi> mutableLiveData = new MutableLiveData<>();
    private static WordRepositoryInpl wordRepositoryInpl;

    public static WordRepositoryInpl getInstance(){
        if (wordRepositoryInpl == null){
            wordRepositoryInpl = new WordRepositoryInpl();
        }
        return wordRepositoryInpl;
    }

    private Dataapi dataapi;

    private WordRepositoryInpl(){
        dataapi = Api.createRequest();

    }
    @Override
    public LiveData<Tuvungapi> getWord() {
        Call<Tuvungapi> tuvungapiCall = dataapi.getWord();
        tuvungapiCall.enqueue(new Callback<Tuvungapi>() {
            @Override
            public void onResponse(Call<Tuvungapi> call, Response<Tuvungapi> response) {
                Tuvungapi tuvungapi = response.body();
                if (tuvungapi.getSuccess()){
                    mutableLiveData.setValue(tuvungapi);
                }
            }

            @Override
            public void onFailure(Call<Tuvungapi> call, Throwable t) {
                mutableLiveData.setValue(null);
            }
        });
        return mutableLiveData;
    }




}
