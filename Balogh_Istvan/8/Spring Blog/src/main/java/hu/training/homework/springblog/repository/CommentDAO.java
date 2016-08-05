package hu.training.homework.springblog.repository;

import hu.training.homework.springblog.model.Comment;

import java.util.List;

public interface CommentDAO {

    void addComment(Comment comment);

    List<Comment> getCommentsOfPost(String postId);

}
