package com.akashprojects.springbootcore.ex2;

import com.akashprojects.springbootcore.ex2.dto.User;
import com.akashprojects.springbootcore.ex2.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.util.List;

@Controller
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    public void loadUserData() throws IOException
    {
        List<User> userList =  userService.getUsers();
        for (User user: userList)
        {
            System.out.println(user);
        }
        System.out.println(" Users Data written to file");
    }
}
