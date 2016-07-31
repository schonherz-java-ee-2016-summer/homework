package hu.schonherz.training.dao.impl;

import hu.schonherz.training.dao.CommentDao;
import hu.schonherz.training.mapper.CommentMapper;
import hu.schonherz.training.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Roli on 2016. 07. 30..
 */
@Repository
public class CommentDaoImpl implements CommentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Comment> getAllCommentByBlogId(int id) {

        return jdbcTemplate.query("SELECT id, blog_id, date, comment FROM public.\"Comment\" WHERE blog_id = ?;",
                new CommentMapper(), id);
    }

    @Override
    public void addComment(Comment comment) {
        jdbcTemplate.update("INSERT INTO public.\"Comment\"(blog_id, comment, date) VALUES (?, ?, ?)",
                comment.getBlogId(), comment.getContent(), comment.getDate()
        );
    }
}
