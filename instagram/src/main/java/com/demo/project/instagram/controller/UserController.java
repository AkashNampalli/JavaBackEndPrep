package com.demo.project.instagram.controller;

import com.demo.project.instagram.dto.User;
import com.demo.project.instagram.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    
    private final UserService userService;


    @GetMapping("/{userId}")
    public ResponseEntity<User> getUser(@PathVariable("userId") Integer userId)
    {
       User user = userService.getUser(userId);
        return user != null ? new ResponseEntity<>(user, HttpStatus.OK) :  new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> saveUser(@RequestBody  User user)
    {
        userService.saveUser(user);
        return  new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@PathVariable("userId") Integer userId, @RequestBody User user)
    {
        User userExist = userService.getUser(userId);
        if(userExist == null)
        {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        user.setUserId(userId);
        userService.updateUser(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public  ResponseEntity<HttpStatus> deleteUser(@PathVariable("userId") Integer userId)
    {
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers()
    {
        return new ResponseEntity<>(userService.getUsers(), HttpStatus.OK);
    }
}
