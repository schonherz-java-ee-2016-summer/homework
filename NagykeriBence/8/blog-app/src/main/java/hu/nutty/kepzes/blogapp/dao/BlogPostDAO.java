package hu.nutty.kepzes.blogapp.dao;

import hu.nutty.kepzes.blogapp.dto.BlogPostDTO;

import java.util.List;

/**
 * Created by Nutty on 2016.07.26..
 */
public interface BlogPostDAO {
    List<BlogPostDTO> getAllBlogPosts();

    BlogPostDTO getBlogPostById(int postID);

    void addBlogPost(BlogPostDTO blogPost);

    int addBlogPostAndReturnId(BlogPostDTO blogPost);
}
