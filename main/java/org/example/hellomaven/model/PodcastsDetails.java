package main.java.org.example.hellomaven.model;

public class PodcastsDetails {
    private int podcast_detail_id;
    private int playlist_id;
    private int podcast_id;
    private int episode_no,release_year;
    private String podcast_name,celebrity_name,podcast_duration,podcast_path;
    public PodcastsDetails(int podcast_detail_id,int playlist_id,int podcast_id,int release_year,String podcast_name,String celebrity_name,String podcast_duration,String podcast_path)
    {
        this.podcast_detail_id=podcast_detail_id;
        this.playlist_id=playlist_id;
        this.podcast_id=podcast_id;
        this.release_year=release_year;
        this.podcast_name=podcast_name;
        this.celebrity_name=celebrity_name;
        this.podcast_duration=podcast_duration;
        this.podcast_path=podcast_path;
    }

    public int getPodcast_detail_id() {
        return podcast_detail_id;
    }

    public void setPodcast_detail_id(int podcast_detail_id) {
        this.podcast_detail_id = podcast_detail_id;
    }

    public int getPlaylist_id() {
        return playlist_id;
    }

    public void setPlaylist_id(int playlist_id) {
        this.playlist_id = playlist_id;
    }

    public int getPodcast_id() {
        return podcast_id;
    }

    public void setPodcast_id(int podcast_id) {
        this.podcast_id = podcast_id;
    }

    public int getEpisode_no() {
        return episode_no;
    }

    public int getRelease_year() {
        return release_year;
    }

    public String getPodcast_duration() {
        return podcast_duration;
    }

    public String getPodcast_path() {
        return podcast_path;
    }

    public void setPodcast_path(String podcast_path) {
        this.podcast_path = podcast_path;
    }

    public void setPodcast_duration(String podcast_duration) {
        this.podcast_duration = podcast_duration;
    }

    public String getPodcast_name() {
        return podcast_name;
    }

    public String getCelebrity_name() {
        return celebrity_name;
    }

    public void setCelebrity_name(String celebrity_name) {
        this.celebrity_name = celebrity_name;
    }

    public void setPodcast_name(String podcast_name) {
        this.podcast_name = podcast_name;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public void setEpisode_no(int episode_no) {
        this.episode_no = episode_no;
    }

    @Override
    public String toString() {
        System.out.println("Podcast Name                 CelebrityName                Podcast Duration");

        return   podcast_name +"            "+celebrity_name +"                "+podcast_duration;
    }

    }

