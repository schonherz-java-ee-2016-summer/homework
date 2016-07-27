package hu.nutty.kepzes.blogapp.dao;

import hu.nutty.kepzes.blogapp.beans.BlogPost;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Nutty on 2016.07.26..
 */
public interface BlogPostDAO {
    List<BlogPost> getAllBlogPosts();

    BlogPost getBlogPostById(int postID);

    void createBlogPost(int postID, LocalDateTime time, String title, String message, int bloggerID);
}
