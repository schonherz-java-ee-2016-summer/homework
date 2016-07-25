package hu.schonherz.traning.homeworksix.pojo;

import java.time.LocalDateTime;

/**
 * Created by Mindfield on 2016. 07. 21..
 */
public class BlogComment {

    private int identity;
    private LocalDateTime date;
    private String content;

    public BlogComment() {
    }

    public BlogComment(int identity, LocalDateTime date, String content) {
        this.identity = identity;
        this.date = date;
        this.content = content;
    }

    public int getIdentity() {
        return identity;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    public void setIdentity(int identity) {
        this.identity = identity;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BlogComment that = (BlogComment) o;

        if (identity != that.identity) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        return content != null ? content.equals(that.content) : that.content == null;

    }

    @Override
    public int hashCode() {
        int result = identity;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BlogComment{" +
                "identity=" + identity +
                ", date=" + date +
                ", content='" + content + '\'' +
                '}';
    }
}
