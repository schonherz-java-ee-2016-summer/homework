package hu.schonherz.basicblogger.service;

import hu.schonherz.basicblogger.entity.Comment;
import hu.schonherz.basicblogger.dao.CommentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bmbal on 2016.08.06..
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public List<Comment> getAllCommentByBlogId(Long blogId) {
        List<Comment> comments = commentDao.getByBlogId(blogId);
        return comments;
    }

    @Override
    public void createComment(Comment comment) {
        commentDao.save(comment);
    }
}
