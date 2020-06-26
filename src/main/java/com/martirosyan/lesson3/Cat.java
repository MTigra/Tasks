package com.martirosyan.lesson3;

import java.util.Random;

public class Cat implements Participant {

    private static final Random rnd = new Random();

    private final int maxHeignt;
    private final int maxLenght;


    public Cat() {
        maxHeignt = rnd.nextInt(1000);
        maxLenght = rnd.nextInt(1000);
    }

    public boolean run(int lenght) {
        boolean succes = lenght < maxLenght;
        if (succes) {
            System.out.println("кот пробежал");
        } else {
            System.out.println("кот не пробежал");
        }
        return succes;
    }

    public boolean jump(int height) {
        boolean succes = height < maxHeignt;
        if (succes) {
            System.out.println("кот прыгнул");
        } else {
            System.out.println("кот не прыгнул");
        }
        return succes;
    }
}
