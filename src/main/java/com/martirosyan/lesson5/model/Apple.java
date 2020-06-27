package com.martirosyan.lesson5.model;

public class Apple extends Fruit {
    private static final float WEIGHT = 1.0f;

    public Apple() {
        this(WEIGHT);
    }

    public Apple(float weight) {
        super(weight);
    }
}
