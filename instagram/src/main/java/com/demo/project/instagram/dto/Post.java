package com.demo.project.instagram.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class Post {
    private Integer id;
    private String name;
    private String description;
    private Integer postedUserId;
    private Map<Integer, Comment> commentsMap;

    // Initializer block executes after Object creation
    {
        commentsMap = new HashMap<>();
    }
}
