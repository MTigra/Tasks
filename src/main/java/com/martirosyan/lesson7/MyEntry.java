package com.martirosyan.lesson7;

import java.util.Random;

public class MyEntry {
    public Integer getK() {
        return k;
    }

    public void setK(Integer k) {
        this.k = k;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    Integer k;
    Integer v;

    public MyEntry(int k, int v) {
        this.k = k;
        this.v = v;
    }
}

