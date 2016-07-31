package hu.schonherz.traning.homeworkseven.dao.mapper;

import hu.schonherz.traning.homeworkseven.dao.pojo.Post;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Mindfield on 2016. 07. 31..
 */
public class PostMapper implements RowMapper<Post> {

    @Override
    public Post mapRow(ResultSet resultSet, int rowNumber) throws SQLException {
        Post post = new Post();
        post.setIdentity(resultSet.getInt("id"));
        post.setCreator(resultSet.getString("creator"));
        post.setDate(resultSet.getDate("date"));
        post.setTitle(resultSet.getString("title"));
        post.setText(resultSet.getString("text"));

        return post;
    }
}
