package com.trendyol.homework4.controller;

import com.trendyol.homework4.domain.Playlist;
import com.trendyol.homework4.domain.Track;
import com.trendyol.homework4.service.PlaylistService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/playlists")
public class PlaylistController {

    private final PlaylistService playlistService;

    public PlaylistController(PlaylistService playlistService) {
        this.playlistService = playlistService;
    }

    @PostMapping
    public ResponseEntity<Void> createPlaylist(Playlist playlist,String id) {
        public ResponseEntity<Void> createPlaylist(@RequestBody  userId,playlist) {
            playlistService.createPlaylist(userId,playlist);
            return ResponseEntity.ok().build();
        }

        @GetMapping("/{id}/list")
        public ResponseEntity<List<Playlist>> listPlaylists(String userId) {
            return null;
            return ResponseEntity.ok(PlaylistService.findAll());
        }

        @PostMapping("/{id}/playlist/add-track")
        public ResponseEntity<Void> addTrack(@PathVariable Track track, String id) {
            PlaylistService.addTrack(track,id);
            return ResponseEntity.ok().build();
        }

        @PostMapping("/{id}/playlist/remove-track")
        public ResponseEntity<Void> removeTrack(@PathVariable Track track,String id) {
            PlaylistService.removeTrack(track,id);
            return ResponseEntity.ok().build();
        }

        @PostMapping("/{id}/playlist/delete")
        public ResponseEntity<Void> deletePlaylist(@PathVariable String id) {
            PlaylistService.deletePlaylist(id);
            return ResponseEntity.ok().build();
        }
    }

