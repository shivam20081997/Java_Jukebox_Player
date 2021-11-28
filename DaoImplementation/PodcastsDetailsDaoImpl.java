package DaoImplementation;

import Dao.PodcastDetailsDao;

import DatabaseConncetion.DatabaseConfiguration;

import main.java.org.example.hellomaven.model.Podcasts;
import main.java.org.example.hellomaven.model.PodcastsDetails;
import main.java.org.example.hellomaven.model.Songs_Detail;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/*podcast_detail_id int not null,
playlist_id int not null,
podcast_id int not null,
release_year int not null,
podcast_name varchar(40) not null,
celebrity_name varchar(40) not null,
podcast_path varchar(1000) not null,*/
public class PodcastsDetailsDaoImpl implements PodcastDetailsDao {
    @Override
    public boolean addpodcastsToPlaylist(Podcasts podcast, int playlist_id, int podcast_detail_id) {
        try (Connection con = DatabaseConfiguration.getConnection()) {
            String query = "insert into podcast_details(podcast_detail_id,playlist_id,podcast_id,release_year,podcast_name,celebrity_name,duration,podcast_path) values (?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, podcast_detail_id);
            preparedStatement.setInt(2, playlist_id);
            preparedStatement.setInt(3, podcast.getPodcast_id());
            preparedStatement.setInt(4,podcast.getRelease_year());
            preparedStatement.setString(5,podcast.getPodcast_name());
            preparedStatement.setString(6,podcast.getCelebrity_name());
            preparedStatement.setString(7,podcast.getPodcast_duration());
            preparedStatement.setString(8,podcast.getPodcast_path());
            int count = preparedStatement.executeUpdate();
            if (count > 0) {
                System.out.println("Podcast Inserted Successfully");
            } else {
                System.out.println("Podcast Insertion Failed");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public List<PodcastsDetails> searchByPodcastName(String podcastName) {
        List<PodcastsDetails> pd=new ArrayList<PodcastsDetails>();
        try (Connection con = DatabaseConfiguration.getConnection()) {
            String query = "select * from podcast_details where podcast_name = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, podcastName);
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                pd.add(new PodcastsDetails(resultSet.getInt(1), resultSet.getInt(2),
                        resultSet.getInt(3), resultSet.getInt(4),
                        resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8)));
                return pd;

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<PodcastsDetails> getAllPodcasts() {
        List<PodcastsDetails> all_podcasts=new ArrayList<>();
        try (Connection con = DatabaseConfiguration.getConnection()) {
            Statement s1=con.createStatement();
            ResultSet resultSet=s1.executeQuery("select * from podcast_details");
            while (resultSet.next())
                if (resultSet.next()) {
                    all_podcasts.add(new PodcastsDetails(resultSet.getInt(1), resultSet.getInt(2),
                            resultSet.getInt(3), resultSet.getInt(4),
                            resultSet.getString(5),resultSet.getString(6),resultSet.getString(7),resultSet.getString(8)));
                    return all_podcasts;
                } else {
                    return null;
                }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}


