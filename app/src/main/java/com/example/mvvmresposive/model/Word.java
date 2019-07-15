package com.example.mvvmresposive.model;

public class Word {
    private String vn;
    private String en;

    public Word(String vn, String en) {
        this.vn = vn;
        this.en = en;
    }

    public String getVn() {
        return vn;
    }

    public void setVn(String vn) {
        this.vn = vn;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }
}
