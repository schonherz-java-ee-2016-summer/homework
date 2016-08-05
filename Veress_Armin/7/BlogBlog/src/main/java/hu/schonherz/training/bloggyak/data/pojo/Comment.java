package hu.schonherz.training.bloggyak.data.pojo;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by Lenovo on 2016.07.29..
 */
public class Comment implements Serializable {

    private int id;
    private int postId;
    private String author;
    private String content;
    private LocalDateTime date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

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
