package hu.training.homework.simpleblog.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * This class represents blogposts.
 */
public class Post implements Serializable {

    private String id;
    private String author;
    private LocalDateTime dateTime;
    private String title;
    private String content;
    private List<Comment> comments;

    public Post() {
        this.id = UUID.randomUUID().toString();
        this.author = "";
        this.dateTime = LocalDateTime.now();
        this.title = "";
        this.content = "";
        this.comments = new ArrayList<Comment>();
    }

    public Post(String author, String content) {
        this.id = UUID.randomUUID().toString();
        this.author = author;
        this.dateTime = LocalDateTime.now();
        this.title = "";
        this.content = content;
        this.comments = new ArrayList<Comment>();
    }

    public String getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setTitle(String title) {
        this.title = title;
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

        Post post = (Post) o;

        if (!getId().equals(post.getId())) {
            return false;
        }
        if (!getAuthor().equals(post.getAuthor())) {
            return false;
        }
        if (!getDateTime().equals(post.getDateTime())) {
            return false;
        }
        if (getTitle() != null ? !getTitle().equals(post.getTitle()) : post.getTitle() != null) {
            return false;
        }
        if (!getContent().equals(post.getContent())) {
            return false;
        }
        return getComments() != null ? getComments().equals(post.getComments()) : post.getComments() == null;

    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getAuthor().hashCode();
        result = 31 * result + getDateTime().hashCode();
        result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
        result = 31 * result + getContent().hashCode();
        result = 31 * result + (getComments() != null ? getComments().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Post{" +
                "author='" + author + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
