package hu.schonherz.java.training.blog.entity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * A POJO for a comment under a post.
 */
@Entity
@Table(name = "COMMENT")
public class BlogComment extends BaseEntity{

    @Basic
    private Long postId;
    @Basic
    private LocalDateTime date;
    @Basic
    private String content;

    public BlogComment() {
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
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
