package TestCases;

import DaoImplementation.PodcastsDetailsDaoImpl;
import main.java.org.example.hellomaven.model.PodcastsDetails;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import DaoImplementation.PlayListDaoImpl;
import DaoImplementation.PodcastsDaoImpl;
import main.java.org.example.hellomaven.model.PlayList;
import main.java.org.example.hellomaven.model.Podcasts;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import DaoImplementation.SongDaoImpl;
import DatabaseConncetion.DatabaseConfiguration;
import main.java.org.example.hellomaven.model.Song;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PodcastsDetailsDaoImplTest {
    private PodcastsDetailsDaoImpl pdi;
    private List<PodcastsDetails> p=new ArrayList<>();
    @BeforeEach
    public void setUp() throws SQLException {
        pdi=new PodcastsDetailsDaoImpl();
        try(Connection con = DatabaseConfiguration.getConnection())
        {
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery("select * from podcast_details");
            while(rs.next())
            {
                p.add(new PodcastsDetails(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getInt(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }

    }

    @AfterEach
    void tearDown()
    {
        pdi=null;
    }



    @Test
    void getAllPodcasts() {

    }
}