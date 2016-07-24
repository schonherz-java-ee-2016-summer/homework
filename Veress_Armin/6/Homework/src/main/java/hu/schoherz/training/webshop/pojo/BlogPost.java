package hu.schoherz.training.webshop.pojo;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import javax.xml.stream.events.Comment;

/**
 * Created by Lenovo on 2016.07.22..
 */
public class BlogPost {
    private String id;
    private String author;
    private LocalDateTime dateOfPosting;
    private String title;
    private String contentOfPost;
    private List<Comment> commentsOfPost;

    public BlogPost(
            String id, String author, LocalDateTime dateOfPosting,
            String title, String contentOfPost, List<Comment> commentsOfPost) {
        this.id = id;
        this.author = author;
        this.dateOfPosting = dateOfPosting;
        this.title = title;
        this.contentOfPost = contentOfPost;
        this.commentsOfPost = commentsOfPost;
    }

    public BlogPost() {
        this.id = "";
        this.author = "";
        this.dateOfPosting = LocalDateTime.now();
        this.title = "";
        this.contentOfPost = "";
        this.commentsOfPost = new ArrayList<Comment>();
    }

    public BlogPost(String id, String author, String title, String contentOfPost) {
        this.id = id;
        this.author = author;
        this.dateOfPosting = LocalDateTime.now();
        this.title = title;
        this.contentOfPost = contentOfPost;
        this.commentsOfPost = new ArrayList<Comment>();
    }

    public String getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDateTime getDateOfPosting() {
        return dateOfPosting;
    }

    public String getTitle() {
        return title;
    }

    public String getContentOfPost() {
        return contentOfPost;
    }

    public List<Comment> getCommentsOfPost() {
        return commentsOfPost;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDateOfPosting(LocalDateTime dateOfPosting) {
        this.dateOfPosting = dateOfPosting;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContentOfPost(String contentOfPost) {
        this.contentOfPost = contentOfPost;
    }

    public void setCommentsOfPost(List<Comment> commentsOfPost) {
        this.commentsOfPost = commentsOfPost;
    }

    @Override
    public String toString() {
        return "Post{" +
                "author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", time=" + dateOfPosting +
                ", content='" + contentOfPost + '\'' +
                '}';
    }
}