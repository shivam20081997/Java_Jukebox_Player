package Dao;
import java.util.List;

import main.java.org.example.hellomaven.model.Song;

public interface SongDao {
    List<Song> searchBySongName(String songName);

    List<Song> searchByArtistName(String songName);

    List<Song> getAllSong();

    Song getSongPathByName(String songName);

    Song getSongById(int id);

}
