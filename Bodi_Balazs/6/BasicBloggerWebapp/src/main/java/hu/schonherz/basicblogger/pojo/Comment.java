package hu.schonherz.basicblogger.pojo;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by bmbal on 2016. 07. 19..
 * Class describes comments
 * //comment(id,date,content)
 */
public class Comment implements Serializable{
    private int id;
    private String author;
    private LocalDateTime date;
    private String content;

    public Comment(int id, String author, LocalDateTime date, String content) {
        this.id = id;
        this.author = author;
        this.date = date;
        this.content = content;
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

    public String getContent() {
        return content;
    }
}
