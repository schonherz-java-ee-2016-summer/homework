package hu.schonherz.basicblogger.data.comment;

import java.io.Serializable;
import java.text.SimpleDateFormat;

/**
 * Created by bmbal on 2016. 07. 19..
 * Class describes comments
 * //comment(id,date,content)
 */
public class Comment implements Serializable{
    private int id;
    private String author;
    private SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
    private String content;

    public Comment(int id, SimpleDateFormat date, String content) {
        this.id = id;
        this.date = date;
        this.content = content;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDate(SimpleDateFormat date) {
        this.date = date;
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

    public String getContent() {
        return content;
    }



    @Override
    public String toString() {
        return "Comment{" +
                "commenter='" + author + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
