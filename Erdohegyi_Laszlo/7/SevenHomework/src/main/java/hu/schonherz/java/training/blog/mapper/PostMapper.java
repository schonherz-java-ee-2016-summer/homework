package hu.schonherz.java.training.blog.mapper;

import hu.schonherz.java.training.blog.model.BlogPost;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class PostMapper implements RowMapper<BlogPost> {

    @Override
    public BlogPost mapRow(ResultSet rs, int rowNum) throws SQLException {
        BlogPost post = new BlogPost();
        post.setId(rs.getInt("id"));
        post.setAuthor(rs.getString("author"));
        post.setTitle(rs.getString("title"));
        post.setContent(rs.getString("content"));
        return post;
    }

}
