package com.martirosyan.lesson3;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Participant[] participants = new Participant[5];
        Obstacle[] obstacles = new Obstacle[5];
        Random rnd = new Random();

        //Fill participants arr
        for (int i = 0; i < participants.length; i++) {
            int rand = rnd.nextInt(3);
            if (rand == 0)
                participants[i] = new Cat();
            if (rand == 1)
                participants[i] = new Human();
            if (rand == 2)
                participants[i] = new Robot();
        }

        //Firr obstacles arr
        for (int i = 0; i < obstacles.length; i++) {
            if (rnd.nextBoolean()) {
                obstacles[i] = new Wall(rnd.nextInt(1000));
            } else {
                obstacles[i] = new RunningTrack(rnd.nextInt(1000));
            }

        }

        for (Participant p : participants) {
            for (Obstacle ob : obstacles){
                System.out.println(p);
                if(!ob.interact(p)){
                    System.out.println("Приступает следующий участник.");
                    break;
                }
            }

        }
    }
}
