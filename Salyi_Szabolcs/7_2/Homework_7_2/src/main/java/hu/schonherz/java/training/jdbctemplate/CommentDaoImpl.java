package hu.schonherz.java.training.jdbctemplate;

import hu.schonherz.java.training.dao.CommentDao;
import hu.schonherz.java.training.mappers.CommentMapper;
import hu.schonherz.java.training.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Home on 2016. 08. 03..
 */

@Repository
public class CommentDaoImpl implements CommentDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Comment> getAllCommentById(int id) {
        String sql = "SELECT id, blog_id , comment FROM public.\"Comment\" WHERE blog_Id = ?;";
        List<Comment> comments = jdbcTemplate.query(sql, new CommentMapper(), id);
        return comments;
    }

    @Override
    public void addComment(int blogId, String comment) {
        String sql = "INSERT INTO public.\"Comment\" (blog_id , comment) VALUES(?,?);";
        jdbcTemplate.update(sql , blogId , comment);
    }
}
