package hu.schonherz.traning.homeworkseven.dao.jdbctemplate;

import hu.schonherz.traning.homeworkseven.dao.dao.CommentDao;
import hu.schonherz.traning.homeworkseven.dao.mapper.CommentMapper;
import hu.schonherz.traning.homeworkseven.dao.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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
        String sql = "SELECT id, blog_id, date, comment FROM public.\"Comment\" WHERE blog_id = ?;";
        List<Comment> comments = jdbcTemplate.query(sql, new CommentMapper());

        return comments;
    }

    @Override
    public void createComment(int blogIdentity, String comment) {
        String sql = "INSERT INTO public.\"Comment\" (blog_id, date, comment) VALUES (?, ?, ?);";
        jdbcTemplate.update(sql, blogIdentity, new Date(), comment);
    }

}
