package org.example.model;

import java.util.List;

public class Album {
    private String name;
    private List<Track> tracks;

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }

    public List<Track> getTracks() {
        return this.tracks;
    }

    public Album(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name + " - ";
    }

    public String getName() {
        return name;
    }
}


