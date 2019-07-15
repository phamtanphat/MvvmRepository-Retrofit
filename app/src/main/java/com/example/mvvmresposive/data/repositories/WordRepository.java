package com.example.mvvmresposive.data.repositories;

import androidx.lifecycle.LiveData;

import com.example.mvvmresposive.data.model.Tuvungapi;
import com.example.mvvmresposive.data.model.Wordapi;

import java.util.ArrayList;
import java.util.List;

public interface WordRepository {
    LiveData<Tuvungapi> getWord();
}
