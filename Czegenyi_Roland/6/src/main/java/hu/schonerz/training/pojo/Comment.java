package hu.schonerz.training.pojo;

import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Class for representing a comment.
 */
public class Comment {
    private static final AtomicInteger count = new AtomicInteger(0);

    private int id;
    private Date date;
    private String content;

    public Comment(String content) {
        this.id = count.incrementAndGet();
        this.date = new Date();
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
