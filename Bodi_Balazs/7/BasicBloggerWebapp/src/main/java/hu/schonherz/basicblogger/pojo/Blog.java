package hu.schonherz.basicblogger.pojo;

import java.io.Serializable;

/**
 * Created by bmbal on 2016. 07. 19..
 * Class describes the posts
 * //blog(id,author,date,title,content)
 */
public class Blog implements Serializable {
    private int id;
    private String author;
    private String title;
    private String content;

    public Blog() {
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
}
