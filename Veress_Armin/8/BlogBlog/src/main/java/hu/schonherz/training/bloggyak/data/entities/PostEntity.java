package hu.schonherz.training.bloggyak.data.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Lenovo on 2016.07.29..
 */
@Entity
@Table(name = "post")
public class PostEntity extends BaseEntity implements Serializable{

    @Basic
    private String author;

    @Basic
    private String title;

    @Basic
    private String content;

    @Column
    private LocalDateTime date;

    @OneToMany(mappedBy = "postId")
    private List<CommentEntity> comments;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public List<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(List<CommentEntity> comments) {
        this.comments = comments;
    }
}
