package hu.schonherz.training.dao;

import hu.schonherz.training.models.Comment;

import java.util.List;

/**
 * Created by Attila on 2016.07.27..
 */
public interface CommentDao {

    public List<Comment> getAllCommentByPostId(int postId);

    public void createComment(Comment comment);
}
