package hu.nutty.kepzes.blogapp.dao.implementations;

import hu.nutty.kepzes.blogapp.beans.BlogPost;
import hu.nutty.kepzes.blogapp.dao.BlogPostDAO;
import hu.nutty.kepzes.blogapp.dao.BloggerDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import java.sql.Timestamp;
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
        List<BlogPost> blogPosts = jdbcTemplate.query(sql, rs -> {
            List<BlogPost> posts = new ArrayList<>();
            while (rs.next()) {
                BlogPost blog = new BlogPost(
                        rs.getInt("postID"),
                        bloggerDAO.getBloggerById(rs.getInt("bloggerID")),
                        rs.getTimestamp("time").toLocalDateTime(),
                        rs.getString("title"),
                        rs.getString("message")
                );
                posts.add(blog);
            }
            return posts;
        });
        return blogPosts;
    }

    @Override
    public BlogPost getBlogPostById(int id) {
        String sql = "SELECT postID, time, title, message, bloggerID FROM public.\"BlogPosts\" WHERE id = ?;";
        BlogPost blogPost = jdbcTemplate.queryForObject(
                sql,
                (rs, i) -> new BlogPost(
                        rs.getInt("postID"),
                        bloggerDAO.getBloggerById(rs.getInt("bloggerID")),
                        rs.getTimestamp("time").toLocalDateTime(),
                        rs.getString("title"),
                        rs.getString("message")
                ),
                id);
        return blogPost;
    }

    @Override
    public void addBlogPost(BlogPost blogPost) {
        String sql = "INSERT INTO public.\"BlogPosts\"(time, title, message, bloggerID) VALUES (?, ?, ?, ?);";
        Timestamp ts = Timestamp.valueOf(blogPost.getTime());
        jdbcTemplate.update(sql, ts, blogPost.getTitle(), blogPost.getMessage(), blogPost.getBloggerID());
    }

}
