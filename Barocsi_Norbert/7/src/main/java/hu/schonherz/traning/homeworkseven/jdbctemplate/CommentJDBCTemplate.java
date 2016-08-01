package hu.schonherz.traning.homeworkseven.jdbctemplate;

import hu.schonherz.traning.homeworkseven.dao.CommentDao;
import hu.schonherz.traning.homeworkseven.mapper.CommentMapper;
import hu.schonherz.traning.homeworkseven.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * Created by Mindfield on 2016. 07. 31..
 */
@Repository
public class CommentJDBCTemplate implements CommentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Comment> getAllCommentByPostId(int blogId) {
        String sql = "SELECT id, blog_id, time, comment FROM public.\"Comment\" WHERE blog_id = ?;";
        List<Comment> comments = jdbcTemplate.query(sql, new CommentMapper(), blogId);

        return comments;
    }

    @Override
    public void createComment(int blogIdentity, String comment) {
        String sql = "INSERT INTO public.\"Comment\" (blog_id, time, comment) VALUES (?, ?, ?);";
        Timestamp ts = Timestamp.valueOf(LocalDateTime.now());
        jdbcTemplate.update(sql, blogIdentity, ts, comment);
    }

}
