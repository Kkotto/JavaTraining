package org.example.service.impl;

import org.example.model.Album;
import org.example.service.TaskService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TaskThreeServiceImpl implements TaskService {
    private final int ALBUM_QUANTITY = 10;
    private final int TRACK_QUANTITY = 20;
    private final int MIN_TRACK_DURATION = 0;
    private final int MAX_TRACK_DURATION = 180;

    @Override
    public void runTask() {
        Random random = new Random();

        List<Album> albums = new ArrayList<>();
        for (int i = 0; i < ALBUM_QUANTITY; i++) {
            albums.add(new Album("Album" + i));
        }

        albums.forEach(album -> {
            List<Album.Track> tracks = new ArrayList<>();
            for(int i=0; i<TRACK_QUANTITY; i++){
                tracks.add(new Album.Track("Track"+i,
                        random.nextInt(MAX_TRACK_DURATION-MIN_TRACK_DURATION)+MIN_TRACK_DURATION));
                album.setTracks(tracks);
            }
        });
        albums.forEach(Album::print);
    }
}
