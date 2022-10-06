package org.example.model;

import java.util.List;

public class Album {
    private String name;
    private List<Track> tracks;

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public Album(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name + " - ";
    }

    public void print() {
        tracks.stream().filter(track -> track.duration > track.FIXED_TIME)
                .forEach(track -> System.out.println(this + track.toString()));
    }

    public static class Track {
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
    }
}


