package hu.schonherz.java.training.pojo;

/**
 * Created by Home on 2016. 08. 03..
 */
public class Comment {

    private int id;
    private int blogId;
    private String comment;

    public Comment() {
    }

    public int getId() {
        return id;
    }

    public int getBlogId() {
        return blogId;
    }

    public String getContent() {
        return comment;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public void setContent(String content) {
        this.comment = content;
    }
}
