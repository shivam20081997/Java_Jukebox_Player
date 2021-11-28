package main.java.org.example.hellomaven.model;

public class Songs_Detail {
    //song_detail_id int not null,
    //playlist_id int not null,
    //song_id int not null,
    private int song_detail_id;
    private int playlist_id;
    private int song_id;
    private String song_name,artist_name,album_name,song_duration,song_path;


    public Songs_Detail(int song_detail_id,int playlist_id,int song_id,String song_name,String artist_name,String album_name,String song_duration,String song_path)
    {
        this.song_detail_id=song_detail_id;
        this.playlist_id=playlist_id;
        this.song_id=song_id;
        this.song_name=song_name;
        this.artist_name=artist_name;
        this.album_name=album_name;
        this.song_duration=song_duration;
        this.song_path=song_path;
    }

    public int getSong_detail_id() {
        return song_detail_id;
    }

    public void setSong_detail_id(int song_detail_id) {
        this.song_detail_id = song_detail_id;
    }

    public int getPlaylist_id() {
        return playlist_id;
    }

    public void setPlaylist_id(int playlist_id) {
        this.playlist_id = playlist_id;
    }

    public int getSong_id() {
        return song_id;
    }

    public void setSong_id(int song_id) {
        this.song_id = song_id;
    }

    public String getSong_name() {
        return song_name;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public String getAlbum_name() {
        return album_name;
    }

    public String getSong_duration() {
        return song_duration;
    }

    public void setSong_duration(String song_duration) {
        this.song_duration = song_duration;
    }

    public String getSong_path() {
        return song_path;
    }

    public void setSong_path(String song_path) {
        this.song_path = song_path;
    }

    public void setAlbum_name(String album_name) {
        this.album_name = album_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }

    public void setSong_name(String song_name) {
        this.song_name = song_name;
    }

    @Override
    public String toString() {
        System.out.println("Song Name              ArtistName               AlbumName");
        return
                song_name+"             " +artist_name +"                "+album_name ;
    }
}
