package hu.schonherz.training.dao;

import hu.schonherz.training.models.Post;

import java.util.List;


/**
 * Created by Attila on 2016.07.27..
 */

public interface PostDao {

    public Post getPostByID(Long id);

    public List<Post> getAllPosts();

    public void createPost(Post post);

}
