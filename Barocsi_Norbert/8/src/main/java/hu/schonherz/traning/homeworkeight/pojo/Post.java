package hu.schonherz.traning.homeworkeight.pojo;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Mindfield on 2016. 07. 31..
 */
@Entity
@Table(name = "Blog")
public class Post extends BaseEntity{

    @Basic
    private String creator;
    @Basic
    private LocalDateTime date;
    @Basic
    private String title;
    @Basic
    private String text;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "blogIdentity")
    private List<Comment> comments;

    public Post() {
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
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

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
