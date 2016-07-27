package hu.training.homework.simpleblog.dao.impl;

import hu.training.homework.simpleblog.dao.CommentDAO;
import hu.training.homework.simpleblog.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class JDBCTemplateCommentDAOImpl implements CommentDAO {

    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JDBCTemplateCommentDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void addComment(Comment comment) {
        String sql = "INSERT INTO public.\"Comment\" (id, commenter, dateandtime, contentofcomment) VALUES (?,?,?,?)";
        Timestamp ts = Timestamp.valueOf(comment.getDateTime());
        jdbcTemplate.update(sql, comment.getId(), comment.getCommenter(), ts, comment.getContent());
    }

    @Override
    public Comment getCommentByID(String id) {
        return null;
    }

    @Override
    public List<Comment> getAllComments() {
        return null;
    }

    @Override
    public void updateComment(Comment comment) {

    }

    @Override
    public void deleteComment(Comment comment) {

    }
}
