package hu.schonherz.training.mapper;

import hu.schonherz.training.pojo.Blog;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Roli on 2016. 07. 31..
 */
public class PostMapper implements RowMapper<Blog> {
    @Override
    public Blog mapRow(ResultSet resultSet, int i) throws SQLException {
        Blog blog = new Blog();
        blog.setId(resultSet.getInt("id"));
        blog.setAuthor(resultSet.getString("creator"));
        blog.setDate(resultSet.getTimestamp("date"));
        blog.setTitle(resultSet.getString("title"));
        blog.setContent(resultSet.getString("text"));

        return blog;
    }
}
