package hu.training.homework.springblog.model;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * This POJO class represents comments on blogposts.
 */
@Entity
@Table(name = "CommentJPA")
public class Comment extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Basic
    private String commenter;
    @Basic
    private LocalDateTime dateTime;
    @Basic
    private String content;

    public Comment() {
        this.commenter = "";
        this.dateTime = LocalDateTime.now();
        this.content = "";
    }

    public Comment(String commenter, String content) {
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

        Comment comment = (Comment) o;

        if (!getCommenter().equals(comment.getCommenter())) {
            return false;
        }
        if (!getDateTime().equals(comment.getDateTime())) {
            return false;
        }
        return getContent().equals(comment.getContent());

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
        return "Comment{" +
                "commenter='" + commenter + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
