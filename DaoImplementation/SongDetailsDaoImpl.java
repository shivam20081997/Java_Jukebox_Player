package DaoImplementation;


import Dao.SongDetailsDao;
import DatabaseConncetion.DatabaseConfiguration;

import main.java.org.example.hellomaven.model.PlayList;
import main.java.org.example.hellomaven.model.Song;
import main.java.org.example.hellomaven.model.Songs_Detail;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SongDetailsDaoImpl implements SongDetailsDao {

    @Override
    public boolean addsongsToPlaylist(Song song,int playlist_id,int song_detail_id) {
        try (Connection con = DatabaseConfiguration.getConnection()) {

            String query = "insert into song_details(song_detail_id,playlist_id,song_id,song_name,artist_name,album_name,duration,song_path) values (?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, song_detail_id);
            preparedStatement.setInt(2, playlist_id);
            preparedStatement.setInt(3, song.getSong_id());
            preparedStatement.setString(4, song.getSong_name());
            preparedStatement.setString(5, song.getArtist_name());
            preparedStatement.setString(6, song.getAlbum_name());
            preparedStatement.setString(7, song.getSong_duration());
            preparedStatement.setString(8, song.getSong_path());
            int count = preparedStatement.executeUpdate();
            if (count > 0) {
                System.out.println("Song Successfully Inserted");
            } else {
                System.out.println("Song couldn't be inserted");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }



    @Override
    public List<Songs_Detail> searchBySongName(String songName) {
        List<Songs_Detail> sd= new ArrayList<>();
        try (Connection con = DatabaseConfiguration.getConnection()) {
            String query = "select * from song_details where song_name = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, songName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
              sd.add( new Songs_Detail(resultSet.getInt(1), resultSet.getInt(2),
                        resultSet.getInt(3), resultSet.getString(4),
                        resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8)));
                return sd;

        }} catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }




    @Override
    public List<Songs_Detail> getAllSong() {
        List<Songs_Detail> all_songs=new ArrayList<>();
        try (Connection con = DatabaseConfiguration.getConnection()) {
            Statement s1=con.createStatement();
            ResultSet resultSet=s1.executeQuery("select * from song_details");
            while (resultSet.next())
                if (resultSet.next()) {
                    all_songs.add(new Songs_Detail(resultSet.getInt(1), resultSet.getInt(2),
                            resultSet.getInt(3), resultSet.getString(4),
                            resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8)));
                    return all_songs;
                } else {
                    return null;
                }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    }


