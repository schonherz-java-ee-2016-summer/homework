package hu.schonherz.java.training.pojo;

/**
 * Created by Home on 2016. 07. 28..
 */
public class Comment {

    private int id;
    private int blogId;
    private String author;
    private String Comment;

    public Comment() {
    }

    public int getId() {
        return id;
    }

    public int getBlogId() {
        return blogId;
    }

    public String getComment() {
        return Comment;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
