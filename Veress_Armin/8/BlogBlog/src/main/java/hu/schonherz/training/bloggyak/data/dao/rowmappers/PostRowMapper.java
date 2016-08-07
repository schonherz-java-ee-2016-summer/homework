package hu.schonherz.training.bloggyak.data.dao.rowmappers;

import hu.schonherz.training.bloggyak.data.entities.PostEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by Lenovo on 2016.07.29..
 */
public class PostRowMapper implements RowMapper<PostEntity> {

    @Override
    public PostEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        PostEntity post = new PostEntity();
        post.setId(resultSet.getInt("id"));
        post.setAuthor(resultSet.getString("author"));
        post.setTitle(resultSet.getString("title"));
        post.setContent(resultSet.getString("content"));
        post.setDate(resultSet.getTimestamp("date").toLocalDateTime());
        return post;
    }
}
