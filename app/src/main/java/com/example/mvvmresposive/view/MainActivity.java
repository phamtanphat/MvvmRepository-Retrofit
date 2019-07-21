package com.example.mvvmresposive.view;

import androidx.annotation.Nullable;
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
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.mvvmresposive.R;
import com.example.mvvmresposive.api.ApiConnection;
import com.example.mvvmresposive.api.response.WordResponse;
import com.example.mvvmresposive.base.BaseActivity;
import com.example.mvvmresposive.event.LoadingEvent;
import com.example.mvvmresposive.event.MessageCallback;
import com.example.mvvmresposive.viewmodel.Mainviewmodel;


public class MainActivity extends BaseActivity<Mainviewmodel> {

    EditText edtEn,edtVn;
    Button btnAddword,btnCancel;
    RecyclerView recyclerView;
    ProgressBar progressBar;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        edtEn = findViewById(R.id.edittextEn);
        edtVn = findViewById(R.id.edittextVn);
        btnAddword = findViewById(R.id.buttonAddword);
        btnCancel = findViewById(R.id.buttonCancel);
        recyclerView = findViewById(R.id.recyclerviewWords);
        progressBar = findViewById(R.id.progressBar);
    }

    @Override
    public Mainviewmodel getViewModel() {
        return new Mainviewmodel(new LoadingEvent(progressBar));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mViewModel.tuVung.observe(this, new Observer<WordResponse>() {
            @Override
            public void onChanged(WordResponse wordResponse) {
                Log.d("BBB",wordResponse.getWords().size() + "");
            }
        });
        mViewModel.getWord();



    }
}
