package hu.training.homework.simpleblog.util;

import hu.training.homework.simpleblog.model.Post;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PostMapper implements RowMapper<Post> {

    @Override
    public Post mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Post post = new Post();
        post.setId(resultSet.getString("id"));
        post.setAuthor(resultSet.getString("author"));
        post.setDateTime(resultSet.getTimestamp("dateandtime").toLocalDateTime());
        post.setTitle(resultSet.getString("title"));
        post.setContent(resultSet.getString("contentofpost"));
        return post;
    }
}
