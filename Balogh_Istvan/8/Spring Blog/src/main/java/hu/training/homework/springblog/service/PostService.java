package hu.training.homework.springblog.service;

import hu.training.homework.springblog.model.Comment;
import hu.training.homework.springblog.model.Post;

import java.util.List;

public interface PostService {

    void addPost(Post post);

    Post getPostByID(String id);

    List<Post> getAllPosts();

}
