package hu.schonherz.training.service;

import hu.schonherz.training.models.Post;
import hu.schonherz.training.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Attila on 2016.07.27..
 */

@Service
public class PostService{

    @Autowired
    private PostRepository postRepository;

    public Post getPostByID(Long id) {
        Post post = postRepository.findById(id);
        return post;
    }

    public List<Post> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts;
    }

    public void createPost(Post post) {
        postRepository.save(post);
    }
}
