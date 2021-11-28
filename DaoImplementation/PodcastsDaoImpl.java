package DaoImplementation;

import Dao.PodcastsDao;
import DatabaseConncetion.DatabaseConfiguration;
import main.java.org.example.hellomaven.model.Podcasts;
import main.java.org.example.hellomaven.model.Song;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PodcastsDaoImpl implements PodcastsDao {
    @Override
    public List<Podcasts> searchPodcastByName(String podcastName) {
        List<Podcasts> all_podcasts=new ArrayList<Podcasts>();
        try (Connection con = DatabaseConfiguration.getConnection()) {
            String query = "select * from podcasts where podcast_name = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, podcastName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                all_podcasts.add(new Podcasts(resultSet.getInt(1), resultSet.getInt(2),
                        resultSet.getString(3), resultSet.getString(4),
                        resultSet.getTime(5).toString(),resultSet.getString(6)));
                return all_podcasts;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Podcasts> searchPodcastByCelebrityName(String celebrityName) {
        List<Podcasts> all_podcasts=new ArrayList<Podcasts>();
        try (Connection con = DatabaseConfiguration.getConnection()) {
            String query = "select * from podcasts where celebrity_name = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, celebrityName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                all_podcasts.add(new Podcasts(resultSet.getInt(1), resultSet.getInt(2),
                        resultSet.getString(3), resultSet.getString(4),
                        resultSet.getTime(5).toString(),resultSet.getString(6)));
                return all_podcasts;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Podcasts> getAllPodcast() {
        List<Podcasts> all_podcasts=new ArrayList<Podcasts>();
        try (Connection con = DatabaseConfiguration.getConnection()) {
            Statement s1=con.createStatement();
            ResultSet resultSet=s1.executeQuery("select * from podcasts");
            while (resultSet.next())
                {
                    all_podcasts.add(new Podcasts(resultSet.getInt(1), resultSet.getInt(2),
                            resultSet.getString(3), resultSet.getString(4),
                            resultSet.getTime(5).toString(),resultSet.getString(6)));

                }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return all_podcasts;
    }
    @Override
    public Podcasts getPodcastPathByName(String songName) {
        try(Connection con= DatabaseConfiguration.getConnection())
        {
            String query = "select * from podcasts where podcast_name = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1,songName);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                Podcasts pd =new Podcasts(resultSet.getInt(1), resultSet.getInt(2),
                        resultSet.getString(3), resultSet.getString(4),
                        resultSet.getTime(5).toString(),resultSet.getString(6));
                return pd;
            }
            else
            {
                return null;
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            return null;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
    }
    @Override
   public  Podcasts getPodcastById(int id){
        try(Connection con= DatabaseConfiguration.getConnection())
        {
            String query = "select * from podcasts where podcast_id = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next())
            {
                Podcasts pd =new Podcasts(resultSet.getInt(1), resultSet.getInt(2),
                        resultSet.getString(3), resultSet.getString(4),
                        resultSet.getTime(5).toString(),resultSet.getString(6));
                return pd;
            }
            else
            {
                return null;
            }
        }
        catch(SQLException ex)
        {
            ex.printStackTrace();
            return null;
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
            return null;
        }

    }


}

