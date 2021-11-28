package DaoImplementation;

import Dao.SongDao;
import DatabaseConncetion.DatabaseConfiguration;
import main.java.org.example.hellomaven.model.Podcasts;
import main.java.org.example.hellomaven.model.Song;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class SongDaoImpl implements SongDao {
    @Override
    public List<Song> searchBySongName(String songName) {
        List<Song> songs = new ArrayList<Song>();
        try (Connection con = DatabaseConfiguration.getConnection()) {
            Statement s1 = con.createStatement();
            ResultSet resultSet = s1.executeQuery("select * from songs where song_name='" + songName + "'");
            while (resultSet.next()) {
                songs.add(new Song(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4),
                        resultSet.getTime(5).toString(), resultSet.getString(6)));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return songs;
    }

    @Override
    public List<Song> searchByArtistName(String songName) {
        List<Song> songs2 = new ArrayList<Song>();
        try (Connection con = DatabaseConfiguration.getConnection()) {
            Statement s1 = con.createStatement();
            ResultSet resultSet = s1.executeQuery("select * from songs where artist_name='" + songName + "'");
            while (resultSet.next()) {
                songs2.add(new Song(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4),
                        resultSet.getTime(5).toString(), resultSet.getString(6)));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return songs2;
    }


    @Override
    public List<Song> getAllSong() {
        List<Song> songs = new ArrayList<Song>();
        try (Connection con = DatabaseConfiguration.getConnection()) {
            Statement s1 = con.createStatement();
            ResultSet resultSet = s1.executeQuery("select * from songs");
            while (resultSet.next()) {
                songs.add(new Song(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4),
                        resultSet.getTime(5).toString(), resultSet.getString(6)));

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return songs;
    }

    @Override
    public Song getSongPathByName(String songName) {
        try (Connection con = DatabaseConfiguration.getConnection()) {
            String query = "select * from songs where song_name = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, songName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Song song = new Song(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4),
                        resultSet.getTime(5).toString(), resultSet.getString(6));
                return song;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public Song getSongById(int id) {
        try (Connection con = DatabaseConfiguration.getConnection()) {
            String query = "select * from songs where song_id = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                Song song = new Song(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getString(3), resultSet.getString(4),
                        resultSet.getTime(5).toString(), resultSet.getString(6));
                return song;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }
}

