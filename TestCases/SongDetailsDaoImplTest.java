package TestCases;

import DaoImplementation.*;
import main.java.org.example.hellomaven.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import DatabaseConncetion.DatabaseConfiguration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class SongDetailsDaoImplTest {
    private SongDetailsDaoImpl sdi;
    private List<Songs_Detail> s=new ArrayList<>();
    @BeforeEach
    public void setUp() throws SQLException {
        sdi=new SongDetailsDaoImpl();
        try(Connection con = DatabaseConfiguration.getConnection())
        {
            Statement stm=con.createStatement();
            ResultSet rs=stm.executeQuery("select * from song_details");
            while(rs.next())
            {
                s.add(new Songs_Detail(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
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
    void getAllSong() {

    }
}