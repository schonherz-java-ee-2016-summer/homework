package hu.schonherz.java.training.blog12.data.comment;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by Home on 2016. 07. 18..
 */

/**
 * Instance of this class contain information about
 * the id of the comment, its date and the content.
 */
public class Comment implements Serializable {

    private int id;
    private LocalDateTime date ;
    private String content;

    public Comment() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {

        return id;
    }

    public LocalDateTime getDate() {
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
