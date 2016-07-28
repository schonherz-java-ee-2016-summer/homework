package hu.nutty.kepzes.blogapp.dao.implementations;

import hu.nutty.kepzes.blogapp.beans.BlogPost;
import hu.nutty.kepzes.blogapp.dao.BlogPostDAO;
import hu.nutty.kepzes.blogapp.dao.BloggerDAO;
import hu.nutty.kepzes.blogapp.mapper.BlogPostMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nutty on 2016.07.27..
 */

public class BlogPostDAOImpl implements BlogPostDAO {

    private JdbcTemplate jdbcTemplate;
    @Autowired
    private BloggerDAO bloggerDAO;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<BlogPost> getAllBlogPosts() {
        String sql = "SELECT postID, time, title, message, bloggerID FROM public.\"BlogPosts\";";
        List<BlogPost> BlogPosts = jdbcTemplate.query(sql, rs -> {
            List<BlogPost> posts = new ArrayList<>();
            while (rs.next()) {
                BlogPost blog = new BlogPost();
                blog.setPostID(rs.getInt("postID"));
                blog.setAuthor(bloggerDAO.getBloggerById(rs.getInt("bloggerID")));
                blog.setTime(LocalDateTime.now());
                blog.setTitle(rs.getString("title"));
                blog.setMessage(rs.getString("message"));
                blog.setBloggerID(rs.getInt("bloggerID"));
                posts.add(blog);
            }
            return posts;
        });
        return BlogPosts;
    }

    @Override
    public BlogPost getBlogPostById(int id) {
        String sql = "SELECT postID, time, title, message, bloggerID FROM public.\"BlogPosts\" WHERE id = ?;";
        BlogPost blog = jdbcTemplate.queryForObject(sql, new BlogPostMapper(), id);
        return blog;
    }

    @Override
    public void createBlogPost(int postID, LocalDateTime time, String title, String message, int bloggerID) {
        String sql = "INSERT INTO public.\"BlogPosts\"(postID, time, title, message, bloggerID) VALUES (?, ?, ?, ?, ?);";
        jdbcTemplate.update(sql, postID, time.toString(), title, message, bloggerID);
    }

}
