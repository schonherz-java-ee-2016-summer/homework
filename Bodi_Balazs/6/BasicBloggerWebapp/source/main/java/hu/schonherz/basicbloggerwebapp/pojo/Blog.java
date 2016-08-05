package hu.schonherz.basicbloggerwebapp.pojo;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by bmbal on 2016. 07. 28..
 */
public class Blog implements Serializable {
    private int id;
    private String author;
    private LocalDateTime date;
    private String title;
    private String content;

    public Blog() {
        super();
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

}


