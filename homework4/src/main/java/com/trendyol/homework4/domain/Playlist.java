package com.trendyol.homework4.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Playlist {

    private List<Track> tracks = new ArrayList<>();
    private int playlistId ;
    private String name;
    private String description;
    private int followersCount;
    private int trackCount;
    private String userId;


    public Playlist(int playlistId, String name, String description) {
        this.playlistId = playlistId;
        this.name = name;
        this.description = description;
    }
    public int getTrackCount(){
        return tracks.size();
    }


}
