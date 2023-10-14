package com.demo.project.instagram.dao;

import com.demo.project.instagram.database.PostInMemoryRepository;
import com.demo.project.instagram.dto.Comment;
import com.demo.project.instagram.dto.Post;
import com.demo.project.instagram.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostDAO {

    @Autowired
    private PostInMemoryRepository postCache;

    public Post getPost(Integer postId)
    {
        return postCache.getPost(postId);
    }

    public void publishPost(Post post)
    {
        postCache.publishPost(post);
    }

    public void editPost(Post post)
    {
        postCache.editPost(post);
    }

    public void deletePost(Integer postId)
    {
        postCache.deletePost(postId);
    }

    public List<Post> getPosts()
    {
        return postCache.getPosts();
    }


    public void addComment(Comment comment)
    {
        postCache.addComment(comment);
    }

    public void editComment(Comment comment)
    {
        postCache.editComment(comment);
    }

    public void deleteComment(Integer commentId)
    {
        postCache.deleteComment(commentId);
    }
}
