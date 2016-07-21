package hu.schonherz.training.models;

import java.io.Serializable;
import java.util.*;

/**
 * Created by Attila on 2016.07.18..
 */
public class Post implements Serializable{

    private int postID;
    private String author;
    private String postDate;
    private String title;
    private String content;
    private List<Comment> comments = new ArrayList<Comment>();

    public Post(){}

    public Post(int postID, String author, String postDate, String title, String content) {
        this.postID = postID;
        this.author = author;
        this.postDate = postDate;
        this.title = title;
        this.content = content;
    }

    public int getPostID() {
        return postID;
    }

    public String getAuthor() {
        return author;
    }

    public String getPostDate() {
        return postDate;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
