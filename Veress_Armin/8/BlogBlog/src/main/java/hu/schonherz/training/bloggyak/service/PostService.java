package hu.schonherz.training.bloggyak.service;

import hu.schonherz.training.bloggyak.data.entities.PostEntity;
import java.util.List;

/**
 * Created by Lenovo on 2016.08.07..
 */

public interface PostService{

    public PostEntity getPostById(Long id);

    public List<PostEntity> getAllPosts();

    public void newPost(PostEntity post);
}
