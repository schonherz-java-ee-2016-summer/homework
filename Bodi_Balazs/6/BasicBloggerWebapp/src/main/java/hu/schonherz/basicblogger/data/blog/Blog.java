package hu.schonherz.basicblogger.data.blog;

import hu.schonherz.basicblogger.data.comment.Comment;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by bmbal on 2016. 07. 19..
 * Class describes the posts
 * //blog(id,author,date,title,content)
 */
public class Blog implements Serializable {
    private int id;
    private String author;
    private SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
    private String title;
    private String content;

    public Blog(int id, String author, SimpleDateFormat date, String title, String content) {
        this.id = id;
        this.author = author;
        this.date = date;
        this.title = title;
        this.content = content;
    }

    private List<Comment> comments = new LinkedList<>();


    public void setId(int id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDate(SimpleDateFormat date) {
       this.date = date;
   }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public SimpleDateFormat getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

}
