package hu.schonherz.java.training.blog.jdbctemplate;

import hu.schonherz.java.training.blog.dao.CommentDao;
import hu.schonherz.java.training.blog.mapper.CommentMapper;
import hu.schonherz.java.training.blog.model.BlogComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class CommentJDBCTemplate implements CommentDao {

  @Autowired
  private JdbcTemplate jdbcTemplate;

  @Override
  public List<BlogComment> getAllCommentByPostId(int postId) {
    String sql = "SELECT id, post_id, content FROM public.\"COMMENT\" WHERE post_id = ?;";
    List<BlogComment> comments = jdbcTemplate.query(sql, new CommentMapper(), postId);
    return comments;
  }

  @Override
  public void createComment(int postId, LocalDateTime date, String content) {
    String sql = "INSERT INTO public.\"COMMENT\"(post_id, date, content) VALUES (?, ?, ?);";
    jdbcTemplate.update(sql, postId, date, content);
  }

}
