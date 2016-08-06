package hu.schonherz.training.models;

import javax.persistence.*;
import java.util.*;

/**
 * Created by Attila on 2016.07.18..
 */

@Entity
@Table(name = "Post")
public class Post extends BaseEntity{

    @Basic
    private String author;

    @Basic
    private String postDate;

    @Basic
    private String title;

    @Basic
    private String content;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "postid")
    private List<Comment> comments = new ArrayList<Comment>();

    public Post(){}

    public Post(String author, String postDate, String title, String content) {
        this.author = author;
        this.postDate = postDate;
        this.title = title;
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public String getPostDate() {
        return postDate;
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

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
