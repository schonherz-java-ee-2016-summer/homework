package hu.training.homework.springblog.service.impl;

import hu.training.homework.springblog.model.Post;
import hu.training.homework.springblog.repository.PostRepository;
import hu.training.homework.springblog.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostServiceImpl.class);

    @Autowired
    private PostRepository postRepository;

    @Override
    public void addPost(Post post) {
        postRepository.save(post);
    }

    @Override
    public Post getPostByID(String id) {
        return postRepository.findOne(id);
    }

    @Override
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }
}
