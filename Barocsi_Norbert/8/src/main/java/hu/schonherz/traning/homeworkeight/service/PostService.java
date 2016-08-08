package hu.schonherz.traning.homeworkeight.service;

import hu.schonherz.traning.homeworkeight.pojo.Post;

import java.util.List;

/**
 * Created by Mindfield on 2016. 08. 06..
 */
public interface PostService {

    List<Post> getAllPost();

    Post getPostByIdentity(Long id);

    void createPost(Post post);
}
