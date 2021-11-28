package DaoImplementation;

import Dao.UserDao;
import DatabaseConncetion.DatabaseConfiguration;
import main.java.org.example.hellomaven.model.Song;
import main.java.org.example.hellomaven.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {
    @Override
    public List<User> getAllUsers() {
        List<User> all_users = new ArrayList<>();
        try (Connection con = DatabaseConfiguration.getConnection()) {
            Statement s1 = con.createStatement();
            ResultSet rs = s1.executeQuery("select * from users");
            while (rs.next()) {
                all_users.add(new User(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return all_users;

    }


    @Override
    public User getUserByName(String name) {
        User user_by_name = null;
        try (Connection con = DatabaseConfiguration.getConnection()) {
            Statement s1 = con.createStatement();
            ResultSet rs = s1.executeQuery("select * from users where user_name=" + name);
            if (rs.next()) {
                user_by_name = new User(rs.getInt(1), rs.getString(2));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return user_by_name;
    }

    @Override
    public User getUserById(int id) {
        User user_by_id = null;
        try (Connection con = DatabaseConfiguration.getConnection()) {
            Statement s1 = con.createStatement();
            ResultSet rs = s1.executeQuery("select * from users where user_id=" + id);
            if (rs.next()) {
                user_by_id = new User(rs.getInt(1), rs.getString(2));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return user_by_id;
    }
}

