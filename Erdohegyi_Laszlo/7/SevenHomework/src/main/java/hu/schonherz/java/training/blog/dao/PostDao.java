package hu.schonherz.java.training.blog.dao;

import hu.schonherz.java.training.blog.model.BlogPost;

import java.util.List;

public interface PostDao {

    public List<BlogPost> getAllPost();

    public BlogPost getPostById(int id);

    public default void createPost(String title, String content) {
        this.createPost("Anonymous", title, content);
    }

    public void createPost(String author, String title, String content);

}
