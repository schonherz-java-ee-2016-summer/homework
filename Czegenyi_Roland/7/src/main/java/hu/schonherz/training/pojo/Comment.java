package hu.schonherz.training.pojo;

import java.util.Date;

/**
 * Class for representing a comment.
 */
public class Comment {

    private int id;
    private int blogId;
    private Date date;
    private String content;

    public Comment(int blogId) {
        this.id = id;
        this.blogId = blogId;
        this.date = new Date();
        this.content = content;
    }

    public Comment() {
        this.id = id;
        this.blogId = blogId;
        this.date = new Date();
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
