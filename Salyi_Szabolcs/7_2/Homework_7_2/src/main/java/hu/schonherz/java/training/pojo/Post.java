package hu.schonherz.java.training.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Home on 2016. 08. 03..
 */
public class Post {

    private int id;
    private String author;
    private String title;
    private String content;
    private List<Comment> comments = new ArrayList<>();

    public Post() {
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
