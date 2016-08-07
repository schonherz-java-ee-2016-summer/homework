package hu.schonherz.java.training.blog.service;

import hu.schonherz.java.training.blog.dao.PostDao;
import hu.schonherz.java.training.blog.entity.BlogPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lac on 2016.08.07..
 */
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;

    @Override
    public BlogPost getPostById(Long id) {
        BlogPost post = postDao.findById(id);
        return post;
    }

    @Override
    public List<BlogPost> getAllPosts() {
        List<BlogPost> posts = postDao.findAll();
        return posts;
    }

    @Transactional
    @Override
    public void createPost(BlogPost post) {
        postDao.save(post);
    }

}
