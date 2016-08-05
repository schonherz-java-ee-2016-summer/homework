package hu.schonherz.java.training.blog.model;

import java.time.LocalDateTime;

/**
 * A POJO for a comment under a post.
 */
public class BlogComment {

    private int id;
    private int postId;
    private LocalDateTime date;
    private String content;

    public BlogComment(int id, int postId, LocalDateTime date, String content) {
        this.id = id;
        this.postId = postId;
        this.date = date;
        this.content = content;
    }

    public BlogComment(int postId) {
        this.postId = postId;
    }

    public BlogComment() {
    }

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
