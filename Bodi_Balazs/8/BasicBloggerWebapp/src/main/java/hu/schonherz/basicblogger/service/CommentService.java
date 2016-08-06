package hu.schonherz.basicblogger.service;

import hu.schonherz.basicblogger.entity.Comment;

import java.util.List;

/**
 * Created by bmbal on 2016.08.06..
 */
interface CommentService {

    List<Comment> getAllCommentByBlogId(Long blogId);

    void createComment(Comment comment);
}
