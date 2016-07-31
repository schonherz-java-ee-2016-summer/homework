package hu.schonherz.training.bloggyak.data.dao;

import hu.schonherz.training.bloggyak.data.pojo.Post;

import java.util.List;

/**
 * Created by Lenovo on 2016.07.29..
 */
public interface PostDAO {

    void save(Post post);
    List<Post> findAll();
    Post findById(int id);

}
