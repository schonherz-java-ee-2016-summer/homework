package hu.schonherz.training.mappers;

import hu.schonherz.training.models.Comment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Attila on 2016.07.27..
 */
public class CommentMapper implements RowMapper<Comment>{

    @Override
    public Comment mapRow(ResultSet resultSet, int i) throws SQLException {
        Comment comment = new Comment();
        comment.setCommentID(resultSet.getInt("id"));
        comment.setPostID(resultSet.getInt("post_id"));
        comment.setCommentDate(resultSet.getString("commentdate"));
        comment.setContent(resultSet.getString("content"));
        return comment;
    }
}
