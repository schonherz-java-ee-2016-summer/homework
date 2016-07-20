package hu.schonherz.training.models;

import java.util.List;

/**
 * Created by Attila on 2016.07.18..
 */
public class Blogpost {

    private int ID;
    private String author;
    private String postDate;
    private String title;
    private String content;
    private List<Integer> comments = null;

    public Blogpost(){}

    public Blogpost(int ID, String author, String postDate, String title, String content) {
        this.ID = ID;
        this.author = author;
        this.postDate = postDate;
        this.title = title;
        this.content = content;
    }

    public int getID() {
        return ID;
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

    public List<Integer> getComments() {
        return comments;
    }

    public void setComments(List<Integer> comments) {
        this.comments = comments;
    }

    public void setID(int ID) {
        this.ID = ID;
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
