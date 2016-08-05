package hu.schonherz.basicblogger.mappers;

import hu.schonherz.basicblogger.pojo.Blog;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by bmbal on 2016. 07. 31..
 */
public class BlogMapper implements RowMapper<Blog> {

    @Override
    public Blog mapRow(ResultSet rs, int rowNum) throws SQLException {
        Blog blog = new Blog();
        blog.setId(rs.getInt("id"));
        blog.setAuthor(rs.getString("author"));
        blog.setTitle(rs.getString("title"));
        blog.setContent(rs.getString("content"));
        return blog;
    }

}