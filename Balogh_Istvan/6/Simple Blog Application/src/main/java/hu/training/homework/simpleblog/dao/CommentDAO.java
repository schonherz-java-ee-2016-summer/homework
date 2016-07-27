package hu.training.homework.simpleblog.dao;

import hu.training.homework.simpleblog.model.Comment;

import java.util.List;

public interface CommentDAO {

    void addComment(Comment comment);

    Comment getCommentByID(String id);

    List<Comment> getAllComments();

    void updateComment(Comment comment);

    void deleteComment(Comment comment);

}
