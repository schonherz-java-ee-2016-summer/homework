package hu.schonherz.java.training.blog.pojo;

import java.time.LocalDateTime;

/**
 * A POJO for a comment under a post.
 */
public class BlogComment {

    private int id;
    private LocalDateTime date;
    private String content;

    public BlogComment(int id, LocalDateTime date, String content) {
        this.id = id;
        this.date = date;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
