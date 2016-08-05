package hu.schonherz.basicblogger.jdbcTemplates;

import hu.schonherz.basicblogger.dao.CommentDao;
import hu.schonherz.basicblogger.mappers.CommentMapper;
import hu.schonherz.basicblogger.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by bmbal on 2016. 07. 31..
 */

@Repository
public class CommentJDBCTemplate implements CommentDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Comment> getAllComments(int blog_id) {
        String sql = "SELECT id, blog_id, author, content FROM public.comment WHERE blog_id = ?";
        List<Comment> comments = jdbcTemplate.query(sql, new CommentMapper(), blog_id);
        return comments;
    }

    @Override
    public void createComment(Comment comment) {
        String sql = "Insert into public.comment (blog_id, author, content) VALUES (?,?,?);";
        jdbcTemplate.update(sql, comment.getBlogId(), comment.getAuthor(), comment.getContent());
    }
}
