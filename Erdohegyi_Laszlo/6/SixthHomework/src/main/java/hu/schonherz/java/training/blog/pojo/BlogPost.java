package hu.schonherz.java.training.blog.pojo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lac on 2016.07.18..
 */
public class BlogPost {

    private int id;
    private String author;
    private LocalDateTime date;
    private String title;
    private String content;
    private List<BlogComment> comments;

    public BlogPost(int id, String author, LocalDateTime date, String title, String content, List<BlogComment> comments) {
        this.id = id;
        this.author = author;
        this.date = date;
        this.title = title;
        this.content = content;
        this.comments = comments;
    }

    public BlogPost(int id, String author, LocalDateTime date, String title, String content) {
        this.id = id;
        this.author = author;
        this.date = date;
        this.title = title;
        this.content = content;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<BlogComment> getComments() {
        return comments;
    }

    public void setComments(List<BlogComment> comments) {
        this.comments = comments;
    }

}
