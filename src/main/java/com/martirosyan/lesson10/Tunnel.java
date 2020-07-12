package com.martirosyan.lesson10;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    Semaphore sem;
    public Tunnel() {
        this.sem = new Semaphore(Race.COMPETITORS_COUNT/2);
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void overcome(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                sem.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                sem.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
