package hu.schonherz.training.bloggyak.data.pojo;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by Lenovo on 2016.07.29..
 */

public class Post implements Serializable{

    private int id;
    private String author;
    private String title;
    private String content;
    private LocalDateTime date;
    private CommentBean comments;

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

    public CommentBean getComments() {
        return comments;
    }

    public void setComments(CommentBean comments) {
        this.comments = comments;
    }
}
