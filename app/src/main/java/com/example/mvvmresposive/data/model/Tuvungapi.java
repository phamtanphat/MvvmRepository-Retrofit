package com.example.mvvmresposive.data.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Tuvungapi {

    @SerializedName("success")
    @Expose
    private Boolean success;
    @SerializedName("words")
    @Expose
    private List<Wordapi> words = null;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public List<Wordapi> getWords() {
        return words;
    }

    public void setWords(List<Wordapi> words) {
        this.words = words;
    }

}