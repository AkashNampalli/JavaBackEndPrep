package com.demo.project.instagram.database;

import com.demo.project.instagram.dto.Comment;
import com.demo.project.instagram.dto.Post;
import com.demo.project.instagram.dto.User;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class PostInMemoryRepository {
    private Map<Integer, Post> postsMap ;
    private Map<Integer, Comment> commentsMap ;

    private Map<Integer, Set<Integer>> userPostsMap;
    // key: userId , value: set Of PostId, posted by specific User

    private Integer postIdCounter ;
    private Integer commentIdCounter ;



    @PostConstruct
    public void init()
    {
        postsMap = new HashMap<>();
        commentsMap = new HashMap<>();
        userPostsMap = new HashMap<>();

        postIdCounter = 0;
        commentIdCounter = 0;
    }

    public Post getPost(Integer postId)
    {
       return postsMap.get(postId);
    }

    public void publishPost(Post post)
    {
        ++postIdCounter;
        post.setId(postIdCounter);
        postsMap.put(postIdCounter, post);
    }

    public void editPost(Post post)
    {
        postsMap.put(post.getId(), post);
    }

    public void deletePost(Integer postId)
    {
        postsMap.remove(postId);
    }

    public List<Post> getPosts()
    {
        return postsMap.values().stream().collect(Collectors.toList());
    }


    public void addComment(Comment comment)
    {
        ++commentIdCounter;
        comment.setId(commentIdCounter);
        commentsMap.put(commentIdCounter, comment);
    }

    public void editComment(Comment comment)
    {
        commentsMap.put(comment.getId(), comment);
    }

    public void deleteComment(Integer commentId)
    {
        commentsMap.remove(commentId);
    }

}
