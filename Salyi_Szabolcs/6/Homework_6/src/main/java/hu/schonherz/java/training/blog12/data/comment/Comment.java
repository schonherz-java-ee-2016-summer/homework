package hu.schonherz.java.training.blog12.data.comment;

import java.io.Serializable;
import java.text.SimpleDateFormat;

/**
 * Created by Home on 2016. 07. 18..
 */

/**
 * Instance of this class contain information about
 * the id of the comment, its date and the content.
 */
public class Comment implements Serializable {

    private int id;
    private SimpleDateFormat date = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
    private String content;

    public Comment(int id, SimpleDateFormat date, String content) {
        this.id = id;
        this.date = date;
        this.content = content;
    }

    public void setId(int id) {
        this.id = id;
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

    public SimpleDateFormat getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Comment comment = (Comment) o;

        if (getId() != 0 ? getId() != comment.getId() : comment.getId() != 0)  {
            return false;
        }

        return getContent() != null ? getContent().equals(comment.getContent()) : comment.getContent() == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + date.hashCode();
        result = 31 * result + content.hashCode();
        return result;
    }
}
