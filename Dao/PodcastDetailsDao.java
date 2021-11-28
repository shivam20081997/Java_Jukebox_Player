package Dao;

import main.java.org.example.hellomaven.model.Podcasts;
import main.java.org.example.hellomaven.model.PodcastsDetails;
import main.java.org.example.hellomaven.model.Song;
import main.java.org.example.hellomaven.model.Songs_Detail;


import java.util.List;

public interface PodcastDetailsDao {

    boolean addpodcastsToPlaylist(Podcasts podcast, int playlist_id, int podcast_detail_id);

    List<PodcastsDetails> searchByPodcastName(String podcastName);

    List<PodcastsDetails> getAllPodcasts();
}