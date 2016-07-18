package hu.schonherz.training.models;

import java.util.Date;

/**
 * Created by Attila on 2016.07.18..
 */
public class Comment {

    private int ID;
    private Date commentDate;
    private String content;

    public Comment(int ID, Date commentDate, String content) {
        this.ID = ID;
        this.commentDate = commentDate;
        this.content = content;
    }

    public int getID() {
        return ID;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public String getContent() {
        return content;
    }

}
