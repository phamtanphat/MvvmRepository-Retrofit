package com.example.mvvmresposive.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mvvmresposive.R;
import com.example.mvvmresposive.api.response.WordResponse;
import com.example.mvvmresposive.event.LoadingEvent;
import com.example.mvvmresposive.model.Word;
import com.example.mvvmresposive.viewmodel.WordAdapterModel;

import java.util.ArrayList;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.Viewholder> {

    ArrayList<Word> words;
    ProgressBar progressBar;
    WordAdapterModel wordAdapterModel;


    public WordAdapter(ArrayList<Word> words, ProgressBar progressBar) {
        this.words = words;
        this.progressBar = progressBar;
        wordAdapterModel = new WordAdapterModel(new LoadingEvent(progressBar));
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.dong_item_word,parent,false);
        wordAdapterModel.tuVung.observe((LifecycleOwner) parent.getContext(), new Observer<WordResponse>() {
            @Override
            public void onChanged(WordResponse wordResponse) {
                if (wordResponse != null){
                    words = (ArrayList<Word>) wordResponse.getWords();
                    notifyDataSetChanged();
                }

            }
        });
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        Word word = words.get(position);
        holder.txtEn.setText(word.getEn());
        holder.txtVn.setText(word.getVn());
        holder.btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wordAdapterModel.deleteword(word.getId());
            }
        });

    }

    @Override
    public int getItemCount() {
        return words.size();
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
