package hu.schonherz.training.bloggyak.data.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by Lenovo on 2016.07.29..
 */
@Entity
@Table(name = "comment")
public class CommentEntity extends BaseEntity implements Serializable {

    @Basic
    private String author;

    @Basic
    private String content;

    @Column
    private LocalDateTime date;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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
}
