package hu.schonherz.traning.homeworksix.pojo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mindfield on 2016. 07. 21..
 */
public class BlogPost {

    private int identity;
    private String author;
    private LocalDateTime date;
    private String title;
    private String content;
    private List<BlogComment> comments;

    public BlogPost() {
        comments = new ArrayList<>();
    }



    public int getIdentity() {
        return identity;
    }

    public String getAuthor() {
        return author;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public List<BlogComment> getComments() {
        return comments;
    }

    public void setIdentity(int identity) {
        this.identity = identity;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setComments(List<BlogComment> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "BlogPost{" +
                "identity=" + identity +
                ", author='" + author + '\'' +
                ", date=" + date +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", comments=" + comments +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BlogPost blogPost = (BlogPost) o;

        if (identity != blogPost.identity) return false;
        if (author != null ? !author.equals(blogPost.author) : blogPost.author != null) return false;
        if (date != null ? !date.equals(blogPost.date) : blogPost.date != null) return false;
        if (title != null ? !title.equals(blogPost.title) : blogPost.title != null) return false;
        if (content != null ? !content.equals(blogPost.content) : blogPost.content != null) return false;
        return comments != null ? comments.equals(blogPost.comments) : blogPost.comments == null;

    }

    @Override
    public int hashCode() {
        int result = identity;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (content != null ? content.hashCode() : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        return result;
    }
}
