package hu.schonherz.traning.homeworkseven.mapper;

import hu.schonherz.traning.homeworkseven.pojo.Comment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Mindfield on 2016. 07. 31..
 */
public class CommentMapper implements RowMapper<Comment> {
    @Override
    public Comment mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
        Comment comment = new Comment();
        comment.setIdentity(resultSet.getInt("id"));
        comment.setBlogIdentity(resultSet.getInt("blog_id"));
        comment.setDate(resultSet.getTimestamp("time").toLocalDateTime());
        comment.setContent(resultSet.getString("comment"));

        return comment;
    }
}
