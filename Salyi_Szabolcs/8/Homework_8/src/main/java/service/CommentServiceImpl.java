package service;

import hu.schonherz.java.training.pojo.Comment;
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
public class CommentServiceImpl {

    @Autowired
    private CommentDao commentDao;

    @Autowired
    private PostDao postDao;

    public void addComment(Comment comment){
        Post post = postDao.findOne(comment.getId());
        List<Comment> comments = post.getComments();
        comments.add(comment);
        postDao.save(post);
    }

    public List<Comment> getAllCommentById(Long Id){
        List<Comment> comments = commentDao.getAllCommentById(Id);
        return comments;
    }
}
