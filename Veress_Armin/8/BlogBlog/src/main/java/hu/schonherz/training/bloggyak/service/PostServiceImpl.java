package hu.schonherz.training.bloggyak.service;

import hu.schonherz.training.bloggyak.data.entities.PostEntity;
import hu.schonherz.training.bloggyak.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Lenovo on 2016.08.07..
 */

@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public PostEntity getPostById(Long id) {
        PostEntity post = postRepository.findById(id);
        return post;
    }

    @Override
    public List<PostEntity> getAllPosts() {
        List<PostEntity> posts = postRepository.findAll();
        return posts;
    }

    @Transactional
    @Override
    public void newPost(PostEntity post) {
        postRepository.save(post);
    }
}
