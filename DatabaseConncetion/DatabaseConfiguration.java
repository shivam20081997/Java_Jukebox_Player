package DatabaseConncetion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfiguration {
    public static Connection getConnection() throws SQLException
    {
        Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jukebox","root","password@123");
        return con;
    }
}

