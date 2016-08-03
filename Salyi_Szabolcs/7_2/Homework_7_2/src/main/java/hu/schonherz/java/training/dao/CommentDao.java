package hu.schonherz.java.training.dao;

import hu.schonherz.java.training.pojo.Comment;

import java.util.List;

/**
 * Created by Home on 2016. 08. 03..
 */
public interface CommentDao {

    public List<Comment> getAllCommentById(int id);

    public void addComment(int blogId, String comment);
}
