package hu.training.homework.springblog.model.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CommentDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private String commenter;
    private LocalDateTime dateTime;
    private String content;

    public CommentDto() {
        this.commenter = "";
        this.dateTime = LocalDateTime.now();
        this.content = "";
    }

    public CommentDto(String postID) {
        this.commenter = "";
        this.dateTime = LocalDateTime.MIN;
        this.content = "";
    }

    public CommentDto(String commenter, String content) {
        this.commenter = commenter;
        this.dateTime = LocalDateTime.now();
        this.content = content;
    }

    public String getCommenter() {
        return commenter;
    }

    public void setCommenter(String commenter) {
        this.commenter = commenter;
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

        CommentDto that = (CommentDto) o;

        if (!getCommenter().equals(that.getCommenter())) {
            return false;
        }
        if (!getDateTime().equals(that.getDateTime())) {
            return false;
        }
        return getContent().equals(that.getContent());

    }

    @Override
    public int hashCode() {
        int result = getCommenter().hashCode();
        result = 31 * result + getDateTime().hashCode();
        result = 31 * result + getContent().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "CommentDto{" +
                "commenter='" + commenter + '\'' +
                ", dateTime=" + dateTime +
                ", content='" + content + '\'' +
                '}';
    }
}
