package hu.schonherz.traning.homeworkeight.service.impl;

import hu.schonherz.traning.homeworkeight.dao.CommentDao;
import hu.schonherz.traning.homeworkeight.pojo.Comment;
import hu.schonherz.traning.homeworkeight.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Mindfield on 2016. 08. 08..
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;

    @Override
    public List<Comment> getAllCommentByBlogIdentity(Long blodIdentity) {
        List<Comment> comments = commentDao.getCommentByBlogIdentity(blodIdentity);
        return comments;
    }

    @Transactional
    @Override
    public void createComment(Comment comment) {
        commentDao.save(comment);
    }
}
