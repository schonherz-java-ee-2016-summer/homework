package hu.schonherz.training.service.impl;

import hu.schonherz.training.dao.BlogDao;
import hu.schonherz.training.dao.CommentDao;
import hu.schonherz.training.pojo.Blog;
import hu.schonherz.training.pojo.Comment;
import hu.schonherz.training.service.CommentService;
import hu.schonherz.training.service.mapper.CommentMapper;
import hu.schonherz.training.vo.CommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Roli on 2016. 08. 07..
 */
@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentDao commentDao;

    @Autowired
    BlogDao blogDao;

    @Override
    public void addCommnet(CommentVo commentVo, Long blogId) {
        Blog blog = blogDao.findById(blogId);
        List<Comment> comments = blog.getComments();

        blog.getComments().add(CommentMapper.toDto(commentVo));

        blogDao.save(blog);
    }
}
