package hu.schonherz.training.bloggyak.data.dao;

import hu.schonherz.training.bloggyak.data.pojo.Comment;

import java.util.List;

/**
 * Created by Lenovo on 2016.07.29..
 */
public interface CommentDAO {

    void save(Comment comment);
    List<Comment> findAllByPostId(int postId);

}
