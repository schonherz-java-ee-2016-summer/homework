package hu.schonherz.training.bloggyak.data.dao;

import hu.schonherz.training.bloggyak.data.entities.CommentEntity;

import java.util.List;

/**
 * Created by Lenovo on 2016.07.29..
 */
public interface CommentDAO {

    void save(CommentEntity comment);
    List<CommentEntity> findAllByPostId(int postId);

}
