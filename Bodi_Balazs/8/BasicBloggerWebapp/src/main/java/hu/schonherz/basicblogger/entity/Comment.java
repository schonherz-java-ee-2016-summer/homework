package hu.schonherz.basicblogger.entity;

import javax.persistence.*;

/**
 * Created by bmbal on 2016.08.05..
 */
@Entity
@Table(name = "Comment")
public class Comment extends BaseEntity{


    @Basic
    private Long blogId;

    @Basic
    private String author;

    @Basic
    private String content;

    public Comment() {
    }

    public Comment(Long blogId, String author, String content) {
        this.blogId = blogId;
        this.author = author;
        this.content = content;
    }

    public Long getBlogId() {
        return blogId;
    }

    public void setBlogId(Long blogId) {
        this.blogId = blogId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
