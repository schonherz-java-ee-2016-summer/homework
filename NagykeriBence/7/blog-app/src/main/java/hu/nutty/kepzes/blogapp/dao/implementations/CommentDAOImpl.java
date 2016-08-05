package hu.nutty.kepzes.blogapp.dao.implementations;

import hu.nutty.kepzes.blogapp.beans.Comment;
import hu.nutty.kepzes.blogapp.dao.CommentDAO;
import hu.nutty.kepzes.blogapp.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Nutty on 2016.07.29..
 */
@Repository
public class CommentDAOImpl implements CommentDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Comment> getAllComments() {
        String sql = "SELECT commentid, time, commenter, content, blogpostid FROM public.\"Comments\"";
        List<Comment> comments = jdbcTemplate.query(sql, new CommentMapper());
        return comments;
    }

    @Override
    public List<Comment> getCommentsByPostId(int postID) {
        String sql = "SELECT commentid, commenter, content, time, blogpostid FROM public.\"Comments\" WHERE blogpostid = ?";
        List<Comment> comments = jdbcTemplate.query(sql, new Object[]{postID}, new CommentMapper());

        return comments;
    }

    @Override
    public void addComment(Comment comment) {
        String sql = "INSERT INTO public.\"Comments\"(time, commenter, content, blogpostid) VALUES (?, ?, ?, ?);";
        Timestamp ts = Timestamp.valueOf(comment.getTime());
        jdbcTemplate.update(sql, ts, comment.getCommenter(), comment.getContent(), comment.getBlogPostID());
    }
}
