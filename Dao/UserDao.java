package Dao;


import main.java.org.example.hellomaven.model.Song;
import main.java.org.example.hellomaven.model.User;

import java.util.List;

public interface UserDao{
        public List<User> getAllUsers();
        public User getUserByName(String name);
        public User getUserById(int id);
    }

