package hu.nutty.kepzes.blogapp.mapper;

import hu.nutty.kepzes.blogapp.beans.BlogPost;
import hu.nutty.kepzes.blogapp.beans.Blogger;
import hu.nutty.kepzes.blogapp.dao.implementations.BloggerDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;


public class BlogPostMapper implements RowMapper<BlogPost> {
    @Autowired
    private BloggerDAOImpl bloggerDAO;

    @Override
    public BlogPost mapRow(ResultSet rs, int rowNum) throws SQLException {
        BlogPost blog = new BlogPost();
        blog.setPostID(rs.getInt("postID"));
        //blog.setAuthor(bloggerDAO.getBloggerById(rs.getInt("bloggerID")));
        blog.setAuthor(new Blogger(1,"bence", "nagykéri", "nutty", 22));
        blog.setTime(LocalDateTime.now());
        blog.setTitle(rs.getString("title"));
        blog.setMessage(rs.getString("message"));
        blog.setBloggerID(rs.getInt("bloggerID"));
        return blog;
    }
}
