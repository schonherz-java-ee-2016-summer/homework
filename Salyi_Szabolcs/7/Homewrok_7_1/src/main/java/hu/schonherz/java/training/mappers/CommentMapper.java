package hu.schonherz.java.training.mappers;

import hu.schonherz.java.training.pojo.Comment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Home on 2016. 07. 28..
 */
public class CommentMapper implements RowMapper<Comment> {

    public Comment mapRow(ResultSet rs, int rowNum) throws SQLException{
        Comment comment = new Comment();
        comment.setId(rs.getInt("id"));
        comment.setBlogId(rs.getInt("blogId"));
        comment.setAuthor(rs.getString("author"));
        comment.setComment(rs.getString("comment"));

        return comment;
    }
}
