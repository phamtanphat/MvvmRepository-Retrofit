package com.example.mvvmresposive.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.arch.core.util.Function;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import com.example.mvvmresposive.data.model.Tuvungapi;
import com.example.mvvmresposive.data.repositories.WordRepository;
import com.example.mvvmresposive.data.repositories.WordRepositoryInpl;

public class Mainviewmodel extends AndroidViewModel {

    public Mainviewmodel(@NonNull Application application) {
        super(application);
    }

    private LiveData<Tuvungapi> tuvungapiLiveData = Transformations.map(WordRepositoryInpl.getInstance().getWord(), new Function<Tuvungapi, Tuvungapi>() {
        @Override
        public Tuvungapi apply(Tuvungapi input) {
            return input;
        }
    });

    public LiveData<Tuvungapi> getTuvungapiLiveData() {
        return tuvungapiLiveData;
    }
}
