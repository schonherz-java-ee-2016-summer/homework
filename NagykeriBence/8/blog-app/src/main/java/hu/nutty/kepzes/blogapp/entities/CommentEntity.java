package hu.nutty.kepzes.blogapp.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Encapsulation of a comment.
 * Instances of this class contain information about who posted the comment
 * and of course, the contents of the comment itself.
 */
public class CommentEntity extends BaseEntity {
    private static final long serialVersionUID = 6245145615416L;

    private int commentID;
    private String commenter;
    private String content;
    private LocalDateTime time;
    private int blogPostID;

    public CommentEntity() {
        this.time = LocalDateTime.now();
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public String getFormattedTime() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy. MM. dd. - HH:mm:ss");
        String formattedDateTime = this.time.format(formatter);
        return formattedDateTime;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public int getCommentID() {
        return commentID;
    }

    public String getCommenter() {
        return commenter;
    }

    public void setCommenter(final String commenter) {
        this.commenter = commenter;
    }

    public String getContent() {
        return content;
    }

    public void setContent(final String content) {
        this.content = content;
    }

    public int getBlogPostID() {
        return blogPostID;
    }

    public void setBlogPostID(int blogPostID) {
        this.blogPostID = blogPostID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CommentEntity comment = (CommentEntity) o;

        if (getCommenter() != null ? !getCommenter().equals(comment.getCommenter()) : comment.getCommenter() != null) {
            return false;
        }

        return getContent() != null ? getContent().equals(comment.getContent()) : comment.getContent() == null;

    }

    @Override
    public int hashCode() {
        int result = getCommenter() != null ? getCommenter().hashCode() : 0;
        result = 31 * result + (getContent() != null ? getContent().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CommentEntity{" +
                "commenter='" + commenter + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
