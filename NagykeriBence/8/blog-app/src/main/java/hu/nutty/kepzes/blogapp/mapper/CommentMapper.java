package hu.nutty.kepzes.blogapp.mapper;

import hu.nutty.kepzes.blogapp.beans.Comment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Nutty on 2016.07.29..
 */
public class CommentMapper implements RowMapper<Comment> {
    @Override
    public Comment mapRow(ResultSet resultSet, int i) throws SQLException {
        Comment comment = new Comment();
        comment.setCommentID(resultSet.getInt("commentid"));
        comment.setBlogPostID(resultSet.getInt("blogpostid"));
        comment.setTime(resultSet.getTimestamp("time").toLocalDateTime());
        comment.setCommenter(resultSet.getString("commenter"));
        comment.setContent(resultSet.getString("content"));
        return comment;
    }
}
