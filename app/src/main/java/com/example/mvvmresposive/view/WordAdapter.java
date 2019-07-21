package com.example.mvvmresposive.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmresposive.R;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.Viewholder> {


    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class Viewholder extends RecyclerView.ViewHolder{
        TextView txtEn,txtVn;
        Button btnToggleWord , btnRemove;
        public Viewholder(@NonNull View itemView) {
            super(itemView);
            txtEn = itemView.findViewById(R.id.textviewEn);
            txtVn = itemView.findViewById(R.id.textviewVn);
            btnToggleWord = itemView.findViewById(R.id.buttonToggleWord);
            btnRemove = itemView.findViewById(R.id.buttonRemoveWord);
        }
    }
}
