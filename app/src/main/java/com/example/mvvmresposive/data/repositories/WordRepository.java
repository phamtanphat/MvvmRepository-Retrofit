package com.example.mvvmresposive.data.repositories;

import androidx.lifecycle.LiveData;

import com.example.mvvmresposive.data.model.Tuvungapi;

public interface WordRepository {
    LiveData<Tuvungapi> getWord();

}
