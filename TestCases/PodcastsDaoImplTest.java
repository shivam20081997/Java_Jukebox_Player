package TestCases;

import DaoImplementation.PodcastsDaoImpl;
import main.java.org.example.hellomaven.model.Podcasts;
import org.junit.jupiter.api.Test;
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

import static org.junit.jupiter.api.Assertions.*;

class PodcastsDaoImplTest {

    private PodcastsDaoImpl pdi;
    private List<Podcasts> podcasts=new ArrayList<>();
    @BeforeEach
    public void setUp() throws SQLException {
        pdi=new PodcastsDaoImpl();
        try(Connection con = DatabaseConfiguration.getConnection())
        {
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery("select * from podcasts");
            while(rs.next())
            {
                podcasts.add(new Podcasts(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getString(4),rs.getTime(5).toString(),rs.getString(6)));
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
    void getAllPodcast() {
        List<Podcasts> number=pdi.getAllPodcast();
        assertEquals(3,number.size());
    }



    @Test
    void getPodcastById() {
        Podcasts podcast2=pdi.getPodcastById(1);
        assertEquals(1,podcast2.getPodcast_id());
    }
}