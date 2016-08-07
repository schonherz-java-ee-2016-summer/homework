package hu.nutty.kepzes.blogapp.dao;

import hu.nutty.kepzes.blogapp.dto.CommentDTO;

import java.util.List;

/**
 * Created by Nutty on 2016.07.26..
 */
public interface CommentDAO {
    List<CommentDTO> getAllComments();
    List<CommentDTO> getCommentsByPostId(int postID);
    void  addComment(CommentDTO comment);
    int addCommentAndReturnId(CommentDTO comment);
}
