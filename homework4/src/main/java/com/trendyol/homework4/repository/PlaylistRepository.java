package com.trendyol.homework4.repository;

import com.couchbase.client.core.error.DocumentNotFoundException;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.Collection;
import com.couchbase.client.java.kv.GetResult;
import com.couchbase.client.java.query.QueryResult;
import com.trendyol.homework4.domain.Playlist;
import com.trendyol.homework4.domain.Track;
import com.trendyol.homework4.domain.User;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public class PlaylistRepository {

    private final Cluster couchbaseCluster;
    private final Collection playlistCollection;


    public PlaylistRepository(Cluster couchbaseCluster, Collection roverCollection) {
        this.couchbaseCluster = couchbaseCluster;
        this.playlistCollection = roverCollection;
    }

    public void create(String userId, Playlist playlist) {
        playlistCollection.insert(playlist.getUserId(),userId);
    }


    public Playlist findById(String id) {
        GetResult getResult = playlistCollection.get(id);
        Playlist playlist = getResult.contentAs(Playlist.class);
        return playlist;
    }
    public List<Playlist> findByUserId(String userId) {
        String statement = String.format("Select * from playlist where userId=",userId);
        QueryResult queryResult = couchbaseCluster.query(statement);
        return queryResult.rowsAs(Playlist.class);
    }



    public List<Playlist> findAll(String userId) {
        String statement = String.format("Select userPlaylist from User where userId=", userId);
        QueryResult queryResult = couchbaseCluster.query(statement);
        return queryResult.rowsAs(Playlist.class);
    }
    public void addTrack(Track track,String id){
        playlistCollection.get(findByUserId(id)).(addTrack(track));
    }
    public List<Playlist> removeTrack(Track track,String id){
        GetResult getResult = playlistCollection.get(id);
        Playlist playlist = getResult.contentAs(Playlist.class);
        playlistCollection.remove(track);
        return playlist;
    }
    private void deletePlaylist(String id){
        playlistCollection.remove(id);
    }
}

