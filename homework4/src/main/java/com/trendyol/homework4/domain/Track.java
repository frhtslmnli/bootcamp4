package com.trendyol.homework4.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Track {

    private String name;
    private String length;
    private String artist;

    public Track(String name, String length, String artist) {
        this.name = name;
        this.length = length;
        this.artist = artist;
    }

}
