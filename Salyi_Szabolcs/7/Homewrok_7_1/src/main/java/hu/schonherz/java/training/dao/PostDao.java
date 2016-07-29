package hu.schonherz.java.training.dao;

import hu.schonherz.java.training.pojo.Post;

import java.util.List;

/**
 * Created by Home on 2016. 07. 27..
 */
public interface PostDao {

    public List<Post> getAllPost();

    public Post getPostById(int blogId);

    public void addPost(String title, String author, String content);
}
