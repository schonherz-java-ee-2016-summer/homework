package hu.schonherz.basicblogger.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bmbal on 2016.08.05..
 */
@Entity
@Table(name = "Blog")
public class Blog extends BaseEntity {

    @Basic
    private String author;

    @Basic
    private String title;

    @Basic
    private String content;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "blogId")
    private List<Comment> comments = new ArrayList<>();

    public Blog() {
    }

    public Blog(String author, String title, String content) {
        this.author = author;
        this.title = title;
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
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

    @Override
    public String toString() {
        return "Blog{" +
                "author='" + author + '\'' +
                ", comments=" + comments +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}