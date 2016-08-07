package hu.schonherz.training.bloggyak.data.dao;

import hu.schonherz.training.bloggyak.data.entities.PostEntity;

import java.util.List;

/**
 * Created by Lenovo on 2016.07.29..
 */
public interface PostDAO {

    void save(PostEntity post);
    List<PostEntity> findAll();
    PostEntity findById(int id);

}
