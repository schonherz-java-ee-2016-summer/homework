package hu.schonherz.training.mappers;

import hu.schonherz.training.models.Post;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Attila on 2016.07.27..
 */
public class PostMapper implements RowMapper<Post> {

    @Override
    public Post mapRow(ResultSet resultSet, int i) throws SQLException {
        Post post = new Post();
        post.setPostID(resultSet.getInt("id"));
        post.setAuthor(resultSet.getString("author"));
        post.setTitle(resultSet.getString("title"));
        post.setPostDate(resultSet.getString("postdate"));
        post.setContent(resultSet.getString("content"));
        return post;
    }
}
