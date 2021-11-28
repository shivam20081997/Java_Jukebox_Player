package Dao;

import main.java.org.example.hellomaven.model.Song;
import main.java.org.example.hellomaven.model.Songs_Detail;

import java.util.List;

public interface SongDetailsDao {

    boolean addsongsToPlaylist(Song song,int playlist_id,int song_detail_id);

    List<Songs_Detail> searchBySongName(String songName);

    List<Songs_Detail> getAllSong();
}

