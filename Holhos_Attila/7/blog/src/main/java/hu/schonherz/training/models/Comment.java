package hu.schonherz.training.models;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Attila on 2016.07.18..
 */
public class Comment implements Serializable {

    private int commentID;
    private String commentDate;
    private String content;

    public Comment(){}

    public int getCommentID() {
        return commentID;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public String getContent() {
        return content;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
