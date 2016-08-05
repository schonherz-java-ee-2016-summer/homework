package hu.schonherz.training.service;

import hu.schonherz.training.dao.PostDao;
import hu.schonherz.training.models.Post;
import hu.schonherz.training.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Attila on 2016.07.27..
 */

@Service
public class PostService implements PostDao {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post getPostByID(Long id) {
        Post post = postRepository.findById(id);
        return post;
    }

    @Override
    public List<Post> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts;
    }

    @Override
    public void createPost(Post post) {
        postRepository.save(post);
    }
}
