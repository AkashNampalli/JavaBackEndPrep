package com.demo.project.instagram.controller;

import com.demo.project.instagram.dto.Comment;
import com.demo.project.instagram.dto.Post;
import com.demo.project.instagram.dto.User;
import com.demo.project.instagram.exception.AuthorizationException;
import com.demo.project.instagram.exception.PostNotExistException;
import com.demo.project.instagram.exception.UserNotFoundException;
import com.demo.project.instagram.service.PostService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/posts")
public class PostController {
    
    private final PostService postService;



    @PostMapping
    public ResponseEntity<HttpStatus> publishPost(@RequestBody Post post) throws UserNotFoundException {
        postService.savePost(post);
        return  new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<Post> updatePost(@PathVariable("postId") Integer postId, @RequestBody Post post) throws PostNotExistException, AuthorizationException {

        post.setId(postId);
        postService.editPost(post);
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<Post> getPost(@PathVariable("postId") Integer postId ) throws PostNotExistException {
      return new ResponseEntity<>(postService.getPost(postId), HttpStatus.OK);
    }




    @DeleteMapping("/{postId}")
    public  ResponseEntity<HttpStatus> deletePost(@PathVariable("postId") Integer postId, @RequestParam("userId") Integer userId) throws PostNotExistException, AuthorizationException {
        postService.deletePost(postId,userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Post>> getPosts()
    {
        return new ResponseEntity<>(postService.getPosts(), HttpStatus.OK);
    }

    @PostMapping("/{postId}/comments")
    public ResponseEntity<HttpStatus> addComment(@PathVariable("postId") Integer postId, @RequestBody Comment comment) throws UserNotFoundException, PostNotExistException {
        comment.setPostId(postId);
        postService.addComment(comment);
        return  new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{postId}/comments/{commentId}")
    public ResponseEntity<Comment> updateComment(@PathVariable("postId") Integer postId,  @PathVariable("commentId") Integer commentId,
                                              @RequestBody Comment comment) throws PostNotExistException, UserNotFoundException {

        comment.setId(commentId);
        comment.setPostId(postId);
        postService.editComment(comment);
        return new ResponseEntity<>(comment, HttpStatus.OK);
    }

    @DeleteMapping("/{postId}/comments/{commentId}")
    public ResponseEntity<HttpStatus> deleteComment(@PathVariable("postId") Integer postId,  @PathVariable("commentId") Integer commentId,
                                                @RequestParam("userId") Integer userId) throws PostNotExistException, UserNotFoundException {


        postService.deleteComment(userId,postId,commentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
