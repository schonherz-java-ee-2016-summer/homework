package hu.schonherz.traning.homeworkeight.service;

import hu.schonherz.traning.homeworkeight.pojo.Comment;

import java.util.List;

/**
 * Created by Mindfield on 2016. 08. 06..
 */
public interface CommentService {

    List<Comment> getAllCommentByBlogIdentity(Long blodIdentity);

    void createComment(Comment comment);

}
