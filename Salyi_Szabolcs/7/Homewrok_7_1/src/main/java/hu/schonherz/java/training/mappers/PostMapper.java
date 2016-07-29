package hu.schonherz.java.training.mappers;

import hu.schonherz.java.training.pojo.Post;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by Home on 2016. 07. 28..
 */
public class PostMapper implements RowMapper<Post> {

    public Post mapRow(ResultSet rs, int rowNum) throws SQLException{
        Post post = new Post();
        post.setId(rs.getInt("id"));
        post.setTitle(rs.getString("title"));
        post.setAuthor(rs.getString("author"));
        post.setDate(rs.getDate("date"));
        post.setComment(rs.getString("content"));
        return post;
    }
}
