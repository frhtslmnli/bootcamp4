package com.trendyol.homework4.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class User {

    private String userId;
    private String name;
    private String surname;
    private List<Playlist> usersPlaylist = new ArrayList<>() ;

    public User(String userId, String name, String surname) {
        this.userId = UUID.randomUUID().toString();
        this.name = name;
        this.surname = surname;
    }
}
