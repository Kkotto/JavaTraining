package org.example.service.impl;

import org.example.model.Album;
import org.example.model.Track;
import org.example.service.TaskService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TaskThreeServiceImpl implements TaskService {
    private final int ALBUM_QUANTITY = 10;
    private final int TRACK_QUANTITY = 20;
    private final int MIN_TRACK_DURATION = 0;
    private final int MAX_TRACK_DURATION = 180;
    private final Random random = new Random();

    @Override
    public void runTask() {
        List<Album> albums = createAlbums();
        setTracks(albums);
        albums.forEach(album -> print(album.getName(), album.getTracks()));
    }

    public List<Album> createAlbums() {
        List<Album> albums = new ArrayList<>();
        for (int i = 0; i < ALBUM_QUANTITY; i++) {
            albums.add(new Album("Album" + i));
        }
        return albums;
    }

    public void setTracks(List<Album> albums) {
        for (int i = 0; i < ALBUM_QUANTITY; i++) {
            List<Track> tracks = new ArrayList<>();
            for (int j = 0; j < TRACK_QUANTITY; j++) {
                tracks.add(new Track("Track" + j,
                        random.nextInt(MAX_TRACK_DURATION - MIN_TRACK_DURATION) + MIN_TRACK_DURATION));
            }
            albums.get(i).setTracks(tracks);
        }
    }

    public void print(String albumName, List<Track> tracks) {
        tracks.stream()
                .filter(track -> track.getDuration() > track.getFIXED_TIME())
                .forEach(track -> System.out.println(albumName + " - " + track));
    }

}
