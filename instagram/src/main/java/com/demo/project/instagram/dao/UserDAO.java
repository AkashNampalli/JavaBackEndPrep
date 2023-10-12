package com.demo.project.instagram.dao;

import com.demo.project.instagram.database.InMemoryRepository;
import com.demo.project.instagram.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserDAO {

    @Autowired
    private InMemoryRepository database;

    public User getUser(Integer userId)
    {
        return database.getUser(userId);
    }

    public void saveUser(User user)
    {
        database.saveUser(user);
    }

    public void updateUser(User user)
    {
        database.updateUser(user);
    }

    public void deleteUser(Integer userId)
    {
        database.deleteUser(userId);
    }

    public List<User> getUsers()
    {
        return database.getUsers();
    }
}
