package hu.schonherz.java.training.blog.service;

import hu.schonherz.java.training.blog.entity.BlogPost;

import java.util.List;

public interface PostService {

    List<BlogPost> getAllPosts();

    BlogPost getPostById(Long id);

    void createPost(BlogPost post);

}
