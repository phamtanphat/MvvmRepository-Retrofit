package com.example.mvvmresposive.viewmodel;

import androidx.lifecycle.MutableLiveData;

import com.example.mvvmresposive.api.ApiConnection;
import com.example.mvvmresposive.api.response.WordResponse;
import com.example.mvvmresposive.base.BaseViewModel;
import com.example.mvvmresposive.event.LoadingEvent;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class Mainviewmodel extends BaseViewModel {

    public Mainviewmodel() {
    }

    public Mainviewmodel(LoadingEvent event) {
        ApiConnection.init();
        setLoading(event);
    }
    public MutableLiveData<WordResponse> tuVung = new MutableLiveData<>();

    public void getWord() {
        showProgress();
        ApiConnection.getApi().getWord().enqueue(new Callback<WordResponse>() {
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
            }
        });
    }
}
