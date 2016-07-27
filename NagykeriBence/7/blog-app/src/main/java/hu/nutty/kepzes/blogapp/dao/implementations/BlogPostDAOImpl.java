package hu.nutty.kepzes.blogapp.dao.implementations;

import hu.nutty.kepzes.blogapp.beans.BlogPost;
import hu.nutty.kepzes.blogapp.dao.BlogPostDAO;
import hu.nutty.kepzes.blogapp.mapper.BlogPostMapper;

import org.springframework.jdbc.core.JdbcTemplate;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Nutty on 2016.07.27..
 */

public class BlogPostDAOImpl implements BlogPostDAO {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<BlogPost> getAllBlogPosts() {
        String sql = "SELECT postID, time, title, message, bloggerID FROM public.\"BlogPosts\";";
        List<BlogPost> BlogPosts = jdbcTemplate.query(sql, new BlogPostMapper());
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
