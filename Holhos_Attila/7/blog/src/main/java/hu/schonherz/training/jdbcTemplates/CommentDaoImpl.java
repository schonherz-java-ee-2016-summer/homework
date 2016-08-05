package hu.schonherz.training.jdbcTemplates;

import hu.schonherz.training.dao.CommentDao;
import hu.schonherz.training.mappers.CommentMapper;
import hu.schonherz.training.models.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Attila on 2016.07.27..
 */

@Repository
public class CommentDaoImpl implements CommentDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Comment> getAllCommentByPostId(int postId) {
        String sql = "Select id, post_id, commentdate, content from \"Blog\".\"Comment\" where post_id=?;";
        List<Comment> comments = jdbcTemplate.query(sql, new CommentMapper(), postId);
        return comments;
    }

    @Override
    public void createComment(Comment comment) {
        String sql = "Insert into \"Blog\".\"Comment\" (post_id, commentdate, content) VALUES (?,?,?);";
        jdbcTemplate.update(sql, comment.getPostID(), comment.getCommentDate(), comment.getContent());
    }
}
