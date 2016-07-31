package hu.schonherz.java.training.blog.dao;

import hu.schonherz.java.training.blog.model.BlogComment;

import java.util.List;

public interface CommentDao {
  
  public List<BlogComment> getAllCommentByPostId(int postId);
  
  public void createComment(int postId, String content);

}
