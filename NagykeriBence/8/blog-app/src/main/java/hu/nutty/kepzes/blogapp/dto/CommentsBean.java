package hu.nutty.kepzes.blogapp.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple Java Bean encapsulating a number of "comments".
 * Comments are plain Strings for the sake of simplicity.
 */
public class CommentsBean implements Serializable {
    private static final long serialVersionUID = 1324354353653L;

    private List<CommentDTO> comments = new ArrayList<>();

    public List<CommentDTO> getComments() {
        return comments;
    }

    public void setComments(final List<CommentDTO> comments) {
        this.comments = comments;
    }

    public void addComment(CommentDTO comment) {
        this.comments.add(comment);
    }
}
