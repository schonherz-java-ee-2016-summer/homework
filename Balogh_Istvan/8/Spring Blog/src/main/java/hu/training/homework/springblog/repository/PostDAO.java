package hu.training.homework.springblog.repository;

import hu.training.homework.springblog.model.Post;

import java.util.List;

public interface PostDAO {

    void addPost(Post post);

    Post getPostByID(String id);

    List<Post> getAllPosts();

}
