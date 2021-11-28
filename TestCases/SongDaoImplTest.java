
package TestCases;


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

public class SongDaoImplTest {

    private SongDaoImpl sdi;
    private List<Song> song=new ArrayList<>();

    @BeforeEach
    public void setUp() throws SQLException {
        sdi=new SongDaoImpl();
        try(Connection con = DatabaseConfiguration.getConnection())
        {
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery("select * from songs");
            while(rs.next())
            {
                song.add(new Song(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getTime(5).toString(),rs.getString(6)));
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
        sdi=null;
    }

    @Test
    public void getAllSong()
    {
        List<Song> number=sdi.getAllSong();
        assertEquals(5,number.size());
    }



    @Test
    public void getSongBySongId()
    {
        Song song2=sdi.getSongById(1);
        assertEquals(1,song2.getSong_id());
    }


}