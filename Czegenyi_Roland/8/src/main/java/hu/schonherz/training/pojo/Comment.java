package hu.schonherz.training.pojo;

import javax.persistence.*;
import java.util.Date;

/**
 * Class for representing a comment.
 */
@Entity
@Table(name = "Comment")
public class Comment extends BaseEntity {

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Basic
    private String content;

    public Comment() {
        this.date = new Date();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
