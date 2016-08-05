package hu.schonherz.basicblogger.mappers;

import hu.schonherz.basicblogger.pojo.Comment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by bmbal on 2016. 07. 31..
 */
public class CommentMapper implements RowMapper<Comment> {

    @Override
    public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
        Comment comment = new Comment();
        comment.setId(rs.getInt("id"));
        comment.setBlogId(rs.getInt("blog_id"));
        comment.setAuthor(rs.getString("author"));
        comment.setContent(rs.getString("content"));
        return comment;
    }

}