package hu.schonherz.java.training.blog.service;

import hu.schonherz.java.training.blog.dao.CommentDao;
import hu.schonherz.java.training.blog.entity.BlogComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by lac on 2016.08.07..
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public List<BlogComment> getAllCommentByPostId(Long postId) {
        List<BlogComment> comments = commentDao.getCommentByPostId(postId);
        return comments;
    }

    @Override
    public void createComment(BlogComment comment) {
        commentDao.save(comment);
    }

}
