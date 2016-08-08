package hu.schonherz.java.training.mapper;

import hu.schonherz.java.training.pojo.Post;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Home on 2016. 08. 03..
 */
public class PostMapper implements RowMapper {

    @Override
    public Post mapRow(ResultSet rs, int rowNum) throws SQLException {
        Post post = new Post();
        post.setId(rs.getLong("id"));
        post.setAuthor(rs.getString("author"));
        post.setTitle(rs.getString("title"));
        post.setContent(rs.getString("text"));
        return post;
    }
}
