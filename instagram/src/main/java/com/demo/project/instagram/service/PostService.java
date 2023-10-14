package com.demo.project.instagram.service;

import com.demo.project.instagram.dao.PostDAO;
import com.demo.project.instagram.dao.UserDAO;
import com.demo.project.instagram.dto.Comment;
import com.demo.project.instagram.dto.Post;
import com.demo.project.instagram.dto.User;
import com.demo.project.instagram.exception.AuthorizationException;
import com.demo.project.instagram.exception.PostNotExistException;
import com.demo.project.instagram.exception.UserNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostService {

    private final UserDAO userDAO;
    private final PostDAO postDAO;


    public Post getPost(Integer postId) throws PostNotExistException
    {
        Post post  = postDAO.getPost(postId);
        if(post == null)
        {
            throw new PostNotExistException(postId +" does not exist");
        }
        return post;
    }

    public void savePost(Post post) throws UserNotFoundException
    {
      Integer postedUserId =  post.getPostedUserId();
      throwOnInvalidAccess(postedUserId);
      postDAO.publishPost(post);
    }

    public void editPost(Post post) throws PostNotExistException, AuthorizationException
    {
      throwOnInvalidAccess(post.getPostedUserId(),post.getId());
        postDAO.editPost(post);
    }

    public void deletePost(Integer postId, Integer postedUserId) throws PostNotExistException, AuthorizationException
    {
        Post post = throwOnInvalidAccess(postedUserId,postId);
        postDAO.deletePost(postId);
        Set<Integer> commentIds = post.getCommentsMap().keySet();
        commentIds.forEach(id -> postDAO.deleteComment(id));
    }

    public List<Post> getPosts()
    {
        return postDAO.getPosts();
    }

    public void addComment(Comment comment) throws UserNotFoundException, PostNotExistException {
        throwOnInvalidAccess(comment.getCommentedUserId());
        Post post = getPost(comment.getPostId());
        postDAO.addComment(comment);
        post.getCommentsMap().put(comment.getId(),comment);
    }


    public void editComment(Comment comment) throws UserNotFoundException, PostNotExistException {
        throwOnInvalidAccess(comment.getCommentedUserId());
        Post post = getPost(comment.getPostId());
        if(post.getCommentsMap().containsKey(comment.getId()))
        {
            post.getCommentsMap().put(comment.getId(), comment);
            postDAO.editComment(comment);
        }
    }


    public void deleteComment( Integer userId, Integer postId,Integer commentId) throws UserNotFoundException, PostNotExistException {

        throwOnInvalidAccess(userId);
        Post post = getPost(postId);
        if(post.getCommentsMap().containsKey(commentId))
        {
            post.getCommentsMap().remove(commentId);
            postDAO.deleteComment(commentId);
        }
    }


    public Post throwOnInvalidAccess(Integer userId, Integer postId) throws PostNotExistException, AuthorizationException
    {
        Post post = getPost(postId);
        if(post.getPostedUserId() != userId)
        {
            throw  new AuthorizationException(" User [ "+userId+"] not authorised ");
        }

        return post;
    }

    public void throwOnInvalidAccess(Integer userId) throws UserNotFoundException
    {
        User user = userDAO.getUser(userId);
        if(user == null)
        {
            throw  new UserNotFoundException(" User [ "+userId+"] not authorised ");
        }
    }
}
