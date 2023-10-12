package com.demo.project.instagram.service;

import com.demo.project.instagram.dao.UserDAO;
import com.demo.project.instagram.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO)
    {
        this.userDAO = userDAO;
    }

    public User getUser(Integer userId)
    {
        return userDAO.getUser(userId);
    }

    public void saveUser(User user)
    {
        userDAO.saveUser(user);
    }

    public void updateUser(User user)
    {
        userDAO.updateUser(user);
    }

    public void deleteUser(Integer userId)
    {
        userDAO.deleteUser(userId);
    }

    public List<User> getUsers()
    {
        return userDAO.getUsers();
    }
}
