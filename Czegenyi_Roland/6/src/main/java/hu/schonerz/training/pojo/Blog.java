package hu.schonerz.training.pojo;

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


    public Blog(String author, String title, String content) {
        this.id = count.incrementAndGet();
        this.author = author;
        this.date = new Date();
        this.title = title;
        this.content = content;
        this.comments = new ArrayList<Comment>();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDate(Date date) {
        this.date = date;
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

    public int getId() {

        return id;
    }

    public String getAuthor() {
        return author;
    }

    public Date getDate() {
        return date;
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
}
