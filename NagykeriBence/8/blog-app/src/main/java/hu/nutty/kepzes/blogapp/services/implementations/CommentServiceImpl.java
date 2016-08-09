package hu.nutty.kepzes.blogapp.services.implementations;

import hu.nutty.kepzes.blogapp.dao.CommentDAO;
import hu.nutty.kepzes.blogapp.dto.CommentDTO;
import hu.nutty.kepzes.blogapp.services.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Nutty on 2016.08.07..
 */
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDAO commentDAO;

    @Override
    public List<CommentDTO> getAllCommentsByBlogId(Long blog_id) {
        List<CommentDTO> comments = null;
        try {
            //comments = commentDAO.findByBlogId(blog_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return comments;
    }

    @Override
    public Long addComment(CommentDTO commentDTO) {
        Long id = null;
        try {
            id = commentDAO.save(commentDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public void updateComment(CommentDTO commentDTO) {
        try {
            commentDAO.update(commentDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
