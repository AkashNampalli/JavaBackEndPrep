package com.example.usersapp;

import com.example.usersapp.dto.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class HelloWorldController {

    @GetMapping
    public ResponseEntity<User> getUser()
    {
        User user = User.builder()
                .userId(1)
                .userName("Srinu")
                .build();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
