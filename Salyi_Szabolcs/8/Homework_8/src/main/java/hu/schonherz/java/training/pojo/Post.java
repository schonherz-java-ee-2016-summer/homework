package hu.schonherz.java.training.pojo;

import hu.schonherz.java.training.entity.BaseEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Home on 2016. 08. 03..
 */

@Entity
@Table(name = "Blog")
public class Post extends BaseEntity{

    private static final long serialVersionIUD = 1L;

    @Basic
    private String author;

    @Basic
    private String title;

    @Basic
    private String content;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "blog_id")
    private List<Comment> comments = new ArrayList<>();

    public Post() {
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
