package DaoImplementation;

import Dao.PlaylistDao;
import DatabaseConncetion.DatabaseConfiguration;
import main.java.org.example.hellomaven.model.PlayList;
import main.java.org.example.hellomaven.model.Song;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlayListDaoImpl  implements PlaylistDao{
    @Override
    public void insertIntoPlaylist(int playlistId, String playListName, int UserId) {
        try(Connection connection = DatabaseConfiguration.getConnection()) {
            String query = "insert into playlist(playlist_id,playlist_name,user_id) values (?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, playlistId);
            preparedStatement.setString(2, playListName);
            preparedStatement.setInt(3, UserId);

            int rowsaffected = preparedStatement.executeUpdate();
            {
                if (rowsaffected > 0) {
                    System.out.println("Succesful Creation of Playlist");
                } else {
                    System.out.println("Failed to create Playlist");
                }
            }
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public PlayList searchByPlalistName(String playListName) {
        try (Connection con = DatabaseConfiguration.getConnection()) {
            String query = "select * from playlist where playlist_name = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, playListName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                PlayList playList = new PlayList(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getInt(3));
                return playList;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


    @Override
    public PlayList serachByUserId(int userId)  {
        try (Connection con = DatabaseConfiguration.getConnection()) {
            String query = "select * from playlist where user_id = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                PlayList playList = new PlayList(resultSet.getInt(1), resultSet.getString(2),
                        resultSet.getInt(3));
                return playList;
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}



