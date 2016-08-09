package hu.schonherz.training.pojo;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Class for representing a blog post.
 */
@Entity
@Table(name = "Blog")
public class Blog extends BaseEntity {

    @Basic
    private String author;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Basic
    private String title;

    @Basic
    private String content;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "blogid")
    private List<Comment> comments;

    public Blog() {
        this.date = new Date();
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
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
}
