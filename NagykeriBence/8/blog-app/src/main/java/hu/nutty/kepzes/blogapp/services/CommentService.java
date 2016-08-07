package hu.nutty.kepzes.blogapp.services;

import hu.nutty.kepzes.blogapp.dto.CommentDTO;

/**
 * Created by Nutty on 2016.08.06..
 */
public interface CommentService {
    void addComment(CommentDTO commentDTO, int blogId);
}
