package hu.nutty.kepzes.blogapp.dao;

import hu.nutty.kepzes.blogapp.dto.CommentDTO;

import java.util.List;

/**
 * Created by Nutty on 2016.07.26..
 */
public interface CommentDAO extends BaseDAO<CommentDTO> {
    List<CommentDTO> findByBlogId(Long blog_id);
}
