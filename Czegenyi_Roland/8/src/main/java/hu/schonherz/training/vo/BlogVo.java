package hu.schonherz.training.vo;

import hu.schonherz.training.pojo.Comment;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Class for representing a blog post.
 */
public class BlogVo implements Serializable {

    private static final long serialVersionUID = 58758758L;
    private Long id;
    private String author;
    private Date date;
    private String title;
    private String content;
    private List<Comment> comments;

    public BlogVo() {
        this.date = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
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
