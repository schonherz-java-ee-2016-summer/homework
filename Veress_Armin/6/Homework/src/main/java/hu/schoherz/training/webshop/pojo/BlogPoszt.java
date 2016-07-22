package hu.schoherz.training.webshop.pojo;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Lenovo on 2016.07.22..
 */
public class BlogPoszt {
    private int id;
    private String author;
    private LocalDateTime dateOfPosting;
    private String title;
    private String contentOfPost;
    private List<String> commentsOfPost;

    public BlogPoszt(
            int id, String author, LocalDateTime dateOfPosting,
            String title, String contentOfPost, List<String> commentsOfPost) {
        this.id = id;
        this.author = author;
        this.dateOfPosting = dateOfPosting;
        this.title = title;
        this.contentOfPost = contentOfPost;
        this.commentsOfPost = commentsOfPost;
    }

    public BlogPoszt() {
    }

    public int getId() {
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

    public String contentOfPost() {
        return contentOfPost;
    }

    public List<String> getCommentsOfPost() {
        return commentsOfPost;
    }

    public void setId(int id) {
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

    public void setCommentsOfPost(List<String> commentsOfPost) {
        this.commentsOfPost = commentsOfPost;
    }
}