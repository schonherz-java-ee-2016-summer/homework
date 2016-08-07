package hu.schonherz.java.training.blog.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * A POJO for a post on the blog.
 */
@Entity
@Table(name = "POST")
public class BlogPost extends BaseEntity{

    @Basic
    private String author;
    @Basic
    private LocalDateTime date;
    @Basic
    private String title;
    @Basic
    private String content;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "post_id")
    private List<BlogComment> comments;

    public BlogPost() {
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<BlogComment> getComments() {
        return comments;
    }

    public void setComments(List<BlogComment> comments) {
        this.comments = comments;
    }

}
