package com.demo.project.instagram.database;

import com.demo.project.instagram.dto.User;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class UserInMemoryRepository {
    private Map<Integer, User> userMap ;
    private Integer userIdCounter;

    @PostConstruct
    public void init()
    {
        userMap = new HashMap<>();
        userIdCounter = 0;
    }

    public User getUser(Integer userId)
    {
       return userMap.get(userId);
    }

    public void saveUser(User user)
    {
        ++userIdCounter;
        user.setUserId(userIdCounter);
        userMap.put(userIdCounter,user);
    }

    public void updateUser(User user)
    {
       if(userMap.containsKey(user.getUserId()))
       {
           userMap.put(user.getUserId(),user);
       }
    }

    public void deleteUser(Integer userId)
    {
        if(userMap.containsKey(userId))
        {
            userMap.remove(userId);
        }
    }

    public List<User> getUsers()
    {
        return userMap.values().stream().collect(Collectors.toList());
    }
}
