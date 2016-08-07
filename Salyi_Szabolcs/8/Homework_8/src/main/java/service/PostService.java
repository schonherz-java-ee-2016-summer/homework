package service;

import hu.schonherz.java.training.pojo.Post;

import java.util.List;

/**
 * Created by Home on 2016. 08. 07..
 */

public interface PostService {

    void addPost(Post post);

    Post getPostById(Long Id);

    List<Post> getAllPost();
}
