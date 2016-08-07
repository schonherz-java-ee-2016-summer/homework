package hu.schonherz.training.bloggyak.service;

import hu.schonherz.training.bloggyak.data.entities.CommentEntity;
import java.util.List;

/**
 * Created by Lenovo on 2016.08.07..
 */

public interface CommentService {

    public List<CommentEntity> getAllPostCommentsById(Long postId);

    public void newComment(CommentEntity comment);
}
