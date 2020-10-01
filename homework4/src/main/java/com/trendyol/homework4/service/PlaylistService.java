package com.trendyol.homework4.service;

import com.trendyol.homework4.domain.Playlist;
import com.trendyol.homework4.domain.Track;
import com.trendyol.homework4.repository.PlaylistRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlaylistService {

    private final PlaylistRepository playlistRepository;

    public PlaylistService(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
    }

    public List<Playlist> findAll(String id) {
        return playlistRepository.findByUserId(id);
    }
    public List<Playlist> createPlaylist(String userId,Playlist playlist){
        return playlistRepository.create(userId,playlist);
    }
    public List<Playlist> deletePlaylist(String id){
        this.playlistRepository;
    }
    public void addTrack(Track track,String id){
        this.playlistRepository.addTrack(track,id);
    }
    public void removeTrack(Track track,String id){
        this.playlistRepository.removeTrack(track,id);
    }



}

