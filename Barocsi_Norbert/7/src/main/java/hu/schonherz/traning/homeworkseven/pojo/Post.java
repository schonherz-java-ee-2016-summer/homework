package hu.schonherz.traning.homeworkseven.pojo;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Mindfield on 2016. 07. 31..
 */
public class Post {

    private int identity;
    private String creator;
    private LocalDateTime date;
    private String title;
    private String text;
    private List<Comment> comments;

    public Post() {
    }

    public int getIdentity() {
        return identity;
    }

    public void setIdentity(int identity) {
        this.identity = identity;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
