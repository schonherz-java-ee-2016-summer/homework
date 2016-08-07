package hu.nutty.kepzes.blogapp.entities;

import hu.nutty.kepzes.blogapp.dto.CommentsBean;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Encapsulation of a blog post.
 * Instances of this class contain information about who posted the blog post
 * and of course, the contents of the post itself.
 */
public class BlogPostEntity extends BaseEntity {

    private static final long serialVersionUID = -114946219811259385L;

    private BloggerEntity author;
    private LocalDateTime time;
    private String title;
    private String message;
    private CommentsBean comments;
    private int bloggerID;

    public BlogPostEntity() {
        this.time = LocalDateTime.now();
        this.comments = new CommentsBean();
    }


    public BloggerEntity getAuthor() {
        return author;
    }

    public void setAuthor(BloggerEntity author) {
        this.author = author;
    }

    public String getFormattedTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy. MM. dd. - HH:mm:ss");
        String formattedDateTime = this.time.format(formatter);
        return formattedDateTime;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CommentsBean getComments() {
        return comments;
    }

    public void setComments(CommentsBean comments) {
        this.comments = comments;
    }

    public int getBloggerID() {
        return bloggerID;
    }

    public void setBloggerID(int bloggerID) {
        this.bloggerID = bloggerID;
    }

}
