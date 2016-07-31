package hu.schonherz.training.mapper;

import hu.schonherz.training.pojo.Comment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Roli on 2016. 07. 31..
 */
public class CommentMapper implements RowMapper<Comment> {
    @Override
    public Comment mapRow(ResultSet resultSet, int i) throws SQLException {
        Comment comment = new Comment();
        comment.setId(resultSet.getInt("id"));
        comment.setBlogId(resultSet.getInt("blog_id"));
        comment.setDate(resultSet.getTimestamp("date"));
        comment.setContent(resultSet.getString("comment"));

        return comment;
    }
}
