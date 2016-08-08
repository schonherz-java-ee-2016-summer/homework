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
    private Long postid;

    @Basic
    private String commentDate;

    @Basic
    private String content;

    public Comment(){}

    public Comment(Long id, Long postid, String commentDate, String content) {
        this.setId(id);
        this.postid = postid;
        this.commentDate = commentDate;
        this.content = content;
    }

    public Comment(Long postid) {
        this.postid = postid;
    }

    public Long getPostID() {
        return postid;
    }

    public void setPostID(Long postid) {
        this.postid = postid;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public String getContent() {
        return content;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
