package com.martirosyan.lesson3;

import java.util.Random;

public class Robot implements Participant {
    private static final Random rnd = new Random();

    private final int maxHeignt;
    private final int maxLenght;

    public Robot() {
        maxHeignt = rnd.nextInt(1000);
        maxLenght = rnd.nextInt(1000);
    }

    public boolean run(int lenght) {
        boolean succes = lenght < maxLenght;
        if (succes) {
            System.out.println("робот пробежал");
        } else {
            System.out.println("робот не пробежал");
        }
        return succes;
    }

    public boolean jump(int heignt) {
        boolean succes = heignt < maxHeignt;
        if (succes) {
            System.out.println("робот прыгнул");
        } else {
            System.out.println("робот не прыгнул");
        }
        return succes;
    }
}
