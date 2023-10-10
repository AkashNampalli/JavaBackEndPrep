package com.akashprojects.springbootcore.ex2.service;

import com.akashprojects.springbootcore.ex2.dao.UserDAO;
import com.akashprojects.springbootcore.ex2.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserDAO userDAO;

    public List<User> getUsers() throws IOException
    {
       List<String> userRecords = userDAO.getUserInfo();
        List<User> usersList = new ArrayList<>();

        for(String record : userRecords)
        {
            String[] userRow = record.split("-");
           User user =
                    User.builder()
                    .firstName(userRow[0])
                    .lastName(userRow[1])
                    .build();
           usersList.add(user);
        }

        return usersList;
    }
}
