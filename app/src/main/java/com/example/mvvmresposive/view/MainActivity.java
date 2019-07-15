package com.example.mvvmresposive.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.lifecycle.ViewModelStore;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Observable;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.mvvmresposive.R;
import com.example.mvvmresposive.data.api.Api;
import com.example.mvvmresposive.data.model.Tuvungapi;
import com.example.mvvmresposive.data.model.Wordapi;
import com.example.mvvmresposive.data.service.Dataapi;
import com.example.mvvmresposive.viewmodel.Mainviewmodel;

import java.util.ArrayList;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Mainviewmodel mainviewmodel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainviewmodel = ViewModelProviders.of(this).get(Mainviewmodel.class);
        mainviewmodel.getTuvungapiLiveData().observe(this, new Observer<Tuvungapi>() {
            @Override
            public void onChanged(Tuvungapi tuvungapi) {
                ArrayList<Wordapi> wordapis = new ArrayList<>();
                Log.d("BBB",wordapis.size() + "");
            }
        });
    }
}
