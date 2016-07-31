package hu.schonherz.java.training.blog.mapper;

import hu.schonherz.java.training.blog.model.BlogComment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class CommentMapper implements RowMapper<BlogComment> {

  @Override
  public BlogComment mapRow(ResultSet rs, int rowNum) throws SQLException {
    BlogComment comment = new BlogComment();
    comment.setId(rs.getInt("id"));
    comment.setPostId(rs.getInt("post_id"));
    comment.setContent(rs.getString("content"));
    return comment;
  }
  
}
