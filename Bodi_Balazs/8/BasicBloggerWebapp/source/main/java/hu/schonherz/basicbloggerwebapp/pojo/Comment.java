package hu.schonherz.basicbloggerwebapp.pojo;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by bmbal on 2016. 07. 28..
 */

public class Comment implements Serializable {
    private int id;
    private int blogId;
    private String author;
    private LocalDateTime date;
    private String content;

    public Comment() {
        super();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public int getBlogId() {
        return blogId;
    }


    public String getAuthor() {
        return author;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }
}

