package hu.training.homework.springblog.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * This POJO class represents blogposts.
 */
@Entity
@Table(name = "PostJPA")
public class Post extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Basic
    private String author;
    @Column(name = "dateTime")
    private LocalDateTime dateTime;
    @Basic
    private String title;
    @Basic
    @Lob
    private String content;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "post_id")
    private List<Comment> comments;

    public Post() {
        this.author = "";
        this.dateTime = LocalDateTime.now();
        this.title = "";
        this.content = "";
        this.comments = new ArrayList<Comment>();
    }

    public Post(String author, String content) {
        this.author = author;
        this.dateTime = LocalDateTime.now();
        this.title = "";
        this.content = content;
        this.comments = new ArrayList<Comment>();
    }

    public String getAuthor() {
        return author;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Post post = (Post) o;

        if (!getAuthor().equals(post.getAuthor())) {
            return false;
        }
        if (!getDateTime().equals(post.getDateTime())) {
            return false;
        }
        if (!getTitle().equals(post.getTitle())) {
            return false;
        }
        if (!getContent().equals(post.getContent())) {
            return false;
        }
        return getComments() != null ? getComments().equals(post.getComments()) : post.getComments() == null;

    }

    @Override
    public int hashCode() {
        int result = getAuthor().hashCode();
        result = 31 * result + getDateTime().hashCode();
        result = 31 * result + getTitle().hashCode();
        result = 31 * result + getContent().hashCode();
        result = 31 * result + (getComments() != null ? getComments().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Post{" +
                "author='" + author + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
