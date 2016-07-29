package hu.training.homework.simpleblog.util;

import hu.training.homework.simpleblog.model.Comment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentMapper implements RowMapper<Comment> {

    @Override
    public Comment mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Comment comment = new Comment();
        comment.setId(resultSet.getString("id"));
        comment.setDateTime(resultSet.getTimestamp("dateandtime").toLocalDateTime());
        comment.setCommenter(resultSet.getString("commenter"));
        comment.setContent(resultSet.getString("contentofcomment"));
        comment.setPostID(resultSet.getString("postid"));
        return comment;
    }
}
