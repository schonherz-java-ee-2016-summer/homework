package hu.nutty.kepzes.blogapp.services;

import hu.nutty.kepzes.blogapp.dto.CommentDTO;

import java.util.List;

/**
 * Created by Nutty on 2016.08.06..
 */
public interface CommentService {
    List<CommentDTO> getAllCommentsByBlogId(Long blog_id);
    Long addComment(CommentDTO commentDTO);
    void updateComment(CommentDTO commentDTO);
}
