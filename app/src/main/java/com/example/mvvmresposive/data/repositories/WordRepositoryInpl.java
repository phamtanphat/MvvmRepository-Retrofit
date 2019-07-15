package com.example.mvvmresposive.data.repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mvvmresposive.data.api.Api;
import com.example.mvvmresposive.data.model.Tuvungapi;
import com.example.mvvmresposive.data.service.Dataapi;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WordRepositoryInpl implements WordRepository{
    private MutableLiveData<Tuvungapi> mutableLiveData = new MutableLiveData<>();
    private Dataapi dataapi;

    public WordRepositoryInpl(){
        dataapi = Api.createRequest();
        mutableLiveData.setValue(new Tuvungapi());
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
