package hu.schonherz.basicblogger.pojo;

import java.io.Serializable;

/**
 * Created by bmbal on 2016. 07. 19..
 * Class describes comments
 * //comment(id,date,content)
 */
public class Comment implements Serializable{
    private int id;
    private int blogId;
    private String author;
    private String content;

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public Comment() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
