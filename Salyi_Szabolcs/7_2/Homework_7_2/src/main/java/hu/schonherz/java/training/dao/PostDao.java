package hu.schonherz.java.training.dao;

import hu.schonherz.java.training.pojo.Post;

import java.util.List;

/**
 * Created by Home on 2016. 08. 03..
 */
public interface PostDao {

    public List<Post> getAllPost();

    public void addPost(String author, String title, String content);

    public Post getPostById(int id);


}
