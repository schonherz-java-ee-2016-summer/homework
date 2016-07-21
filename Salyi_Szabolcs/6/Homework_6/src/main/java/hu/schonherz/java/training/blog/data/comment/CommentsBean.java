package hu.schonherz.java.training.blog.data.comment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Home on 2016. 07. 18..
 */

/**
 * Simple Java Bean encapsulating a number of comments.
 */
public class CommentsBean implements Serializable{

    private List<Comment> comments = new ArrayList<Comment>();

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
