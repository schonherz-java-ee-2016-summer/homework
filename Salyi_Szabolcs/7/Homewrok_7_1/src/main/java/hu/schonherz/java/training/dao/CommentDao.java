package hu.schonherz.java.training.dao;

import hu.schonherz.java.training.pojo.Comment;

import java.util.List;

/**
 * Created by Home on 2016. 07. 27..
 */
public interface CommentDao {

    public void addComment(int blogId, String comment);

    public List<Comment> getAllCommnetById(int blogId);
}
