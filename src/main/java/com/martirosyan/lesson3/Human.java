package com.martirosyan.lesson3;

import java.util.Random;

public class Human implements Participant {
    private static final Random rnd = new Random();

    private final int maxHeignt;
    private final int maxLenght;


    public Human() {
        maxHeignt = rnd.nextInt(1000);
        maxLenght = rnd.nextInt(1000);
    }

    public boolean run(int lenght) {
        boolean succes = lenght < maxLenght;
        if (succes) {
            System.out.println("челове пробежал");
        } else {
            System.out.println("человек не пробежал");
        }

        return succes;
    }

    public boolean jump(int height) {
        boolean succes = height < maxHeignt;
        if (succes) {
            System.out.println("человек прыгнул");
        } else {
            System.out.println("человек не прыгнул");
        }
        return succes;
    }

}
