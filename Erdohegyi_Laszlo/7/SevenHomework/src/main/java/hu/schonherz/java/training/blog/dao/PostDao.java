package hu.schonherz.java.training.blog.dao;

import hu.schonherz.java.training.blog.model.BlogPost;

import java.time.LocalDateTime;
import java.util.List;

public interface PostDao {

    public List<BlogPost> getAllPost();

    public BlogPost getPostById(int id);

    public default void createPost(String title, String content) {
        this.createPost("Anonymous", LocalDateTime.now(), title, content);
    }

    public void createPost(String author, LocalDateTime date, String title, String content);

}
