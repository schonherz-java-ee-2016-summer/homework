package hu.schonherz.java.training.mappers;

import hu.schonherz.java.training.pojo.Comment;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Home on 2016. 08. 03..
 */
public class CommentMapper implements RowMapper {

    @Override
    public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
        Comment comment = new Comment();
        comment.setId(rs.getLong("id"));
        //comment.setBlogId(rs.getLong("blog_id"));
        comment.setContent(rs.getString("comment"));
        return comment;
    }
}
