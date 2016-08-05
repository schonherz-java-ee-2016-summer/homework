package hu.schonherz.training.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Attila on 2016.07.18..
 */

@Entity
@Table(name = "Comment")
public class Comment extends BaseEntity {

    @Basic
    private int commentID;

    @Basic
    private Long postID;

    @Basic
    private String commentDate;

    @Lob
    private String content;

    public Comment(){}

    public Long getPostID() {
        return postID;
    }

    public void setPostID(Long postID) {
        this.postID = postID;
    }

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
