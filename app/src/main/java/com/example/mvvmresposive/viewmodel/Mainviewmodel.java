package com.example.mvvmresposive.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.mvvmresposive.data.model.Tuvungapi;
import com.example.mvvmresposive.data.repositories.WordRepositoryInpl;

public class Mainviewmodel extends AndroidViewModel {

    public Mainviewmodel(@NonNull Application application) {
        super(application);
    }
}
