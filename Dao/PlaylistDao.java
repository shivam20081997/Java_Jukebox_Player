package Dao;
import java.util.List;


import main.java.org.example.hellomaven.model.PlayList;
import main.java.org.example.hellomaven.model.PodcastsDetails;
import main.java.org.example.hellomaven.model.Song;
import main.java.org.example.hellomaven.model.Songs_Detail;


public interface PlaylistDao{
    public void insertIntoPlaylist(int playlistId, String playListName, int UserId);
    PlayList searchByPlalistName(String playListName);
    PlayList serachByUserId(int userId);
}