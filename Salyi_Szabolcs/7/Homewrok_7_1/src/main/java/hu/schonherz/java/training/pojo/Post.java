package hu.schonherz.java.training.pojo;

/**
 * Created by Home on 2016. 07. 28..
 */
public class Post {

    private int id;
    private String title;
    private String author;
    //private Date date;
    private String comment;

    public Post() {
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getComment() {
        return comment;
    }

    public void setId(int id) { this.id = id; }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    //public void setDate(Date date) { this.date = date; }

    //public Date getDate() { return date; }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
