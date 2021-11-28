package main.java.org.example.hellomaven.model;

public class PlayList {
    private int playlist_id;
    private String playlist_name;
    private int user_id;

    public PlayList(int playlist_id,String playlist_name,int user_id)
    {
        this.playlist_id=playlist_id;
        this.playlist_name=playlist_name;
        this.user_id=user_id;
    }

    public int getPlaylist_id() {
        return playlist_id;
    }

    public String getPlaylist_name() {
        return playlist_name;
    }

    public void setPlaylist_id(int playlist_id) {
        this.playlist_id = playlist_id;
    }

    public void setPlaylist_name(String playlist_name) {
        this.playlist_name = playlist_name;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "PlayList{" +
                "playlist_id=" + playlist_id +
                ", playlist_name='" + playlist_name + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}
