package hu.training.homework.springblog.service;

import hu.training.homework.springblog.model.Comment;
import hu.training.homework.springblog.model.Post;

import java.util.List;

public interface CommentService {

    void addComment(Comment comment);

    List<Comment> getCommentsOfPost(String postId);

}
