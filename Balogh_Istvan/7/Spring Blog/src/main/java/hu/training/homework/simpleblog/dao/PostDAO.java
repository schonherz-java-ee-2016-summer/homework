package hu.training.homework.simpleblog.dao;

import hu.training.homework.simpleblog.model.Post;

import java.util.List;

public interface PostDAO {

    void addPost(Post post);

    Post getPostByID(String id);

    List<Post> getAllPosts();

    void updatePost(Post post);

    void deletePost(Post post);

}
