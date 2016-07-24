package hu.training.homework.simpleblog.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * This class represents comments on blogposts.
 */
public class Comment implements Serializable {

    private String id;
    private LocalDateTime dateTime;
    private String content;

    public Comment() {
        this.id = UUID.randomUUID().toString();
        this.dateTime = LocalDateTime.MIN;
        this.content = "";
    }

    public Comment(String content) {
        this.id = UUID.randomUUID().toString();
        this.dateTime = LocalDateTime.now();
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

        if (!getId().equals(comment.getId())) {
            return false;
        }
        if (!getDateTime().equals(comment.getDateTime())) {
            return false;
        }
        return getContent() != null ? getContent().equals(comment.getContent()) : comment.getContent() == null;

    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getDateTime().hashCode();
        result = 31 * result + (getContent() != null ? getContent().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", dateTime=" + dateTime +
                ", content='" + content + '\'' +
                '}';
    }
}
