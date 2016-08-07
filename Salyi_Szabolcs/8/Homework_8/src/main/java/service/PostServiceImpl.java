package service;

import hu.schonherz.java.training.pojo.Post;
import hu.schonherz.java.training.repository.CommentDao;
import hu.schonherz.java.training.repository.PostDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Home on 2016. 08. 07..
 */

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private PostDao postDao;

    @Override
    public void addPost(Post post){
        postDao.save(post);
    }

    @Override
    public Post getPostById(Long id){
        Post post = postDao.findOne(id);
        return post;
    }

    @Override
    public List<Post> getAllPost(){
        List<Post> posts = postDao.findAll();
        return  posts;
    }
}
