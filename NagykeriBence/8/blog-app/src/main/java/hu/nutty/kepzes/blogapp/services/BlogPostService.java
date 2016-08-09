package hu.nutty.kepzes.blogapp.services;

import hu.nutty.kepzes.blogapp.dto.BlogPostDTO;

import java.util.List;

/**
 * Created by Nutty on 2016.08.06..
 */
public interface BlogPostService {
    List<BlogPostDTO> getAllBlogPosts();
    BlogPostDTO getBlogPostById(Long id);
    Long createBlogPost(BlogPostDTO blogPostDTO);
    void updateBlogPost(BlogPostDTO blogPostDTO);
}
