package com.trendyol.homework4.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlaylistAppTests {


    @Test
    public void should_create_user(){
        //Arrange
        User user = new User("1","Ferhat","Salmanlı");

        //Act

        //Assert
        assertEquals("1",user.getUserId());
    }
    @Test
    public void should_create_playlist(){
        //Arrange
        Playlist playlist = new Playlist(11,"Playlist","Example");

        //Act
        playlist.setName("Example");

        //Assert
        assertEquals("Example",playlist.getName());
    }
    @Test
    public void should_create_track(){
        //Arrange
        Track track = new Track("Track","240s","Artist");

        //Act

        //Assert
        assertEquals("Track",track.getName());
    }
    @Test
    public void should_add_user_to_playlist(){
        //Arrange
        Playlist playlist = new Playlist(11,"Playlist","Example");
        User user = new User("1","Ferhat","Salmanlı");


        //Act
        playlist.setUserId(user.getUserId());

        //Assert
        assertEquals(1,playlist.getUserId());
    }
    @Test
    public void should_add_track_to_playlist(){
        //Arrange
        Playlist playlist = new Playlist(11,"Playlist","Example");
        Track track = new Track("Track","240s","Artist");

        //Act
        playlist.getTracks().add(track);
        //Assert
        assertEquals("Track",playlist.getTracks().get(0).getName());

    }
    @Test
    public void should_add_playlist_to_user(){
        //Arrange
        Playlist playlist = new Playlist(11,"Playlist","Example");
        User user = new User("1","Ferhat","Salmanlı");


        //Act
        user.getUsersPlaylist().add(playlist);

        //Assert
        assertEquals("Playlist",user.getUsersPlaylist().get(0).getName());
    }



}
