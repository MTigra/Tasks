package com.martirosyan.lesson3;

public class Wall implements Obstacle {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean interact(Participant p) {
        return p.jump(height);
    }
}
