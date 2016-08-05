package hu.training.homework.simpleblog.dao;

import hu.training.homework.simpleblog.model.Comment;

import java.util.List;

public interface CommentDAO {

    void addComment(Comment comment);

    List<Comment> getCommentsOfPost(String postId);

}
