package hu.training.homework.springblog.model.dto;

import hu.training.homework.springblog.model.Comment;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PostDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String author;
    private LocalDateTime dateTime;
    private String title;
    private String content;
    private List<Comment> comments;

    public PostDto() {
        this.author = "";
        this.dateTime = LocalDateTime.now();
        this.title = "";
        this.content = "";
        this.comments = new ArrayList<Comment>();
    }

    public PostDto(String author, String content) {
        this.author = author;
        this.dateTime = LocalDateTime.now();
        this.title = "";
        this.content = content;
        this.comments = new ArrayList<Comment>();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PostDto postDto = (PostDto) o;

        if (!getAuthor().equals(postDto.getAuthor())) {
            return false;
        }
        if (!getDateTime().equals(postDto.getDateTime())) {
            return false;
        }
        if (!getTitle().equals(postDto.getTitle())) {
            return false;
        }
        if (!getContent().equals(postDto.getContent())) {
            return false;
        }
        return getComments() != null ? getComments().equals(postDto.getComments()) : postDto.getComments() == null;

    }

    @Override
    public int hashCode() {
        int result = getAuthor().hashCode();
        result = 31 * result + getDateTime().hashCode();
        result = 31 * result + getTitle().hashCode();
        result = 31 * result + getContent().hashCode();
        result = 31 * result + (getComments() != null ? getComments().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "PostDto{" +
                "author='" + author + '\'' +
                ", dateTime=" + dateTime +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
