package com.martirosyan.lesson3;

public class RunningTrack implements Obstacle {
    private int length;

    public RunningTrack(int length) {
        this.length = length;
    }

    @Override
    public boolean interact(Participant p) {
        return p.run(length);
    }
}
