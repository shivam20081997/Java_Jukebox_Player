package TestCases;

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

class PlayListDaoImplTest {
    private PlayListDaoImpl pdi;
    private List<PlayList> playlist=new ArrayList<>();
    @BeforeEach
    void setUp() throws SQLException {
        pdi=new PlayListDaoImpl();
        try(Connection con = DatabaseConfiguration.getConnection())
        {
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery("select * from playlist");
            while(rs.next())
            {
                playlist.add(new PlayList(rs.getInt(1),rs.getString(2),rs.getInt(3)));
            }
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }

    }


    @AfterEach
    void tearDown() {
        pdi=null;
    }



    @Test
    void searchByPlalistName() {
        PlayList ply= pdi.searchByPlalistName("Relaxation");
        assertEquals("Relaxation",ply.getPlaylist_name());
    }

    @Test
    void serachByUserId() {
        PlayList ply2=pdi.serachByUserId(1);
        assertEquals(1,ply2.getUser_id());
    }
}