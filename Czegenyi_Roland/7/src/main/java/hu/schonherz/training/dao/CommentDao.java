package hu.schonherz.training.dao;

import hu.schonherz.training.pojo.Comment;

import java.util.List;

/**
 * Created by Roli on 2016. 07. 28..
 */
public interface CommentDao {

    public List<Comment> getAllCommentByBlogId(int id);

    public void addComment(Comment comment);

}

