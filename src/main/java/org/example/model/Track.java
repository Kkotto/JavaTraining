package org.example.model;

public class Track {
    private String name;
    private int duration;
    private final int FIXED_TIME = 60;

    public Track(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return this.name + " - " + this.duration;
    }

    public int getDuration() {
        return duration;
    }

    public int getFIXED_TIME() {
        return FIXED_TIME;
    }
}
