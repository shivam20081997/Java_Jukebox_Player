package Dao;
import java.util.List;

import main.java.org.example.hellomaven.model.Podcasts;
import main.java.org.example.hellomaven.model.Song;


public interface PodcastsDao {
    List<Podcasts> searchPodcastByName(String podcastName);
    List<Podcasts> searchPodcastByCelebrityName(String celebrityName);
    List<Podcasts> getAllPodcast();
    Podcasts getPodcastPathByName(String songName);
    Podcasts getPodcastById(int id);
}
