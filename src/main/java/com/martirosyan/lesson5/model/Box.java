package com.martirosyan.lesson5.model;

import java.util.ArrayList;

public class Box<T extends Fruit> {

    private final ArrayList<T> fruits;

    public Box() {
        fruits = new ArrayList<>();
    }

    public Box(ArrayList<T> fruits) {
        this.fruits = fruits;
    }


    public float getWeight() {
        float weight = 0;
        return fruits.stream().map(Fruit::getWeight).reduce(0f, Float::sum);
    }


    public boolean compare(Box o) {
        return this.getWeight() == o.getWeight();
    }

    public void putToAnother(Box<T> another){
        another.addFruits(this.fruits);
        this.fruits.clear();
    }

    public void addFruit(T fruit){
        fruits.add(fruit);
    }

    public void addFruits(ArrayList<T> fruits){
        this.fruits.addAll(fruits);
    }
}
