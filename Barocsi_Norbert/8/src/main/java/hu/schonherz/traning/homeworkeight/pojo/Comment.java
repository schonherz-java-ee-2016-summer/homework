package hu.schonherz.traning.homeworkeight.pojo;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * Created by Mindfield on 2016. 07. 31..
 */
@Entity
@Table(name = "Comment")
public class Comment extends BaseEntity{

    @Basic
    private Long blogIdentity;
    @Basic
    private LocalDateTime date;
    @Basic
    private String content;

    public Comment() {
    }

    public Comment(Long blogIdentity) {
        this.blogIdentity = blogIdentity;
    }

    public Long getBlogIdentity() {
        return blogIdentity;
    }

    public void setBlogIdentity(Long blogidentity) {
        this.blogIdentity = blogidentity;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
