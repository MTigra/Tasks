package com.martirosyan.lesson5.model;

public class Orange extends Fruit{
    private static final float WEIGHT = 1.5f;

    public Orange() {
        this(WEIGHT);
    }

    public Orange(float weight) {
        super(weight);
    }
}
