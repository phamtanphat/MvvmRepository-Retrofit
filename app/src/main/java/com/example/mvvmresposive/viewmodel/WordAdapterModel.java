package com.example.mvvmresposive.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mvvmresposive.api.ApiConnection;
import com.example.mvvmresposive.api.response.WordResponse;
import com.example.mvvmresposive.base.BaseViewModel;
import com.example.mvvmresposive.event.LoadingEvent;
import com.example.mvvmresposive.event.MessageCallback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WordAdapterModel extends BaseViewModel {

    public MutableLiveData<WordResponse> tuVung = new MutableLiveData<>();

    public WordAdapterModel(LoadingEvent loadingEvent) {
        setLoading(loadingEvent);
    }
    public void deleteword(String id , MessageCallback messageCallback){
        showProgress();
        ApiConnection.getApi().delete(id).enqueue(new Callback<WordResponse>() {
            @Override
            public void onResponse(Call<WordResponse> call, Response<WordResponse> response) {
                if (response.isSuccessful()){
                    tuVung.setValue(response.body());
                    hideProgress();
                }
            }

            @Override
            public void onFailure(Call<WordResponse> call, Throwable t) {
                    tuVung.setValue(null);
                    messageCallback.message(t.getMessage());
                    hideProgress();
            }
        });
    }

}
