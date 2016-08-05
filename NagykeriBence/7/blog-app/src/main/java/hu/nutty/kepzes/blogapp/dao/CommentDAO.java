package hu.nutty.kepzes.blogapp.dao;

import hu.nutty.kepzes.blogapp.beans.Comment;

import java.util.List;

/**
 * Created by Nutty on 2016.07.26..
 */
public interface CommentDAO {
    List<Comment> getAllComments();
    List<Comment> getCommentsByPostId(int postID);
    void  addComment(Comment comment);
}
