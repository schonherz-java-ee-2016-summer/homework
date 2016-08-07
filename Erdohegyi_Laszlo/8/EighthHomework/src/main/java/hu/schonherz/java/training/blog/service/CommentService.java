package hu.schonherz.java.training.blog.service;

import hu.schonherz.java.training.blog.entity.BlogComment;

import java.util.List;

/**
 * Created by lac on 2016.08.07..
 */
public interface CommentService {

    List<BlogComment> getAllCommentByPostId(Long postId);

    void createComment(BlogComment comment);

}
