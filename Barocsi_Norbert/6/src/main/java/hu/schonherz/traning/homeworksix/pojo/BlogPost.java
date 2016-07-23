package hu.schonherz.traning.homeworksix.pojo;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Mindfield on 2016. 07. 21..
 */
public class BlogPost {

    private int identity;
    private String author;
    private LocalDateTime date;
    private String title;
    private String content;
    private List<BlogComment> comments;

    public BlogPost() {
    }

    public BlogPost(int identity, String author, LocalDateTime date, String title, String content, List<BlogComment> comments) {
        this.identity = identity;
        this.author = author;
        this.date = date;
        this.title = title;
        this.content = content;
        this.comments = comments;
    }

    public int getIdentity() {
        return identity;
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

    public List<BlogComment> getComments() {
        return comments;
    }

    public void setIdentity(int identity) {
        this.identity = identity;
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

    public void setComments(List<BlogComment> comments) {
        this.comments = comments;
    }
}
