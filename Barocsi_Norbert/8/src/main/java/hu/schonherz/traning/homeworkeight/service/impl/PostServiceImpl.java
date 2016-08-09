package hu.schonherz.traning.homeworkeight.service.impl;

import hu.schonherz.traning.homeworkeight.dao.PostDao;
import hu.schonherz.traning.homeworkeight.pojo.Post;
import hu.schonherz.traning.homeworkeight.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * Created by Mindfield on 2016. 08. 06..
 */
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;


    @Override
    public List<Post> getAllPost() {
        List<Post> posts = postDao.findAll();
        return posts;
    }

    @Override
    public Post getPostByIdentity(Long id) {
        Post post = postDao.findByIdentity(id);
        return post;
    }

    @Transactional
    @Override
    public void createPost(Post post) {
        postDao.save(post);
    }
}
