package hu.schonherz.training.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Class for representing a blog post.
 */

public class Blog {
    private static final AtomicInteger count = new AtomicInteger(0);
    private int id;
    private String author;
    private Date date;
    private String title;
    private String content;
    private List<Comment> comments;

    public Blog() {
        this.id = id;
        this.author = author;
        this.date = new Date();
        this.title = title;
        this.content = content;
        this.comments = new ArrayList<Comment>();
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
