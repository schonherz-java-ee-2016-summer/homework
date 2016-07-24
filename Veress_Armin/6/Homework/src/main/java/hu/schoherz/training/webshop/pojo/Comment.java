package hu.schoherz.training.webshop.pojo;

import java.time.LocalDateTime;

/**
 * Created by Lenovo on 2016.07.22..
 */
public class Comment {
    private int id;
    private LocalDateTime dateOfComment;
    private String contentOfComment;

    public Comment(int id, LocalDateTime dateOfComment, String contentOfComment) {
        this.id = id;
        this.dateOfComment = dateOfComment;
        this.contentOfComment = contentOfComment;
    }

    public Comment() {
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDateOfComment() {
        return dateOfComment;
    }

    public String getContentOfComment() {
        return contentOfComment;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDateOfComment(LocalDateTime dateOfComment) {
        this.dateOfComment = dateOfComment;
    }

    public void setContentOfComment(String contentOfComment) {
        this.contentOfComment = contentOfComment;
    }
}
