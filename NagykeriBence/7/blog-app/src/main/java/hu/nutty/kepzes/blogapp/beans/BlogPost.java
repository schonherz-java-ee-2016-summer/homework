package hu.nutty.kepzes.blogapp.beans;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Encapsulation of a blog post.
 * Instances of this class contain information about who posted the blog post
 * and of course, the contents of the post itself.
 */
public class BlogPost implements Serializable {

    private static final long serialVersionUID = -114946219811259385L;
    private static final AtomicInteger count = new AtomicInteger(0);

    private final int postID;
    private Blogger author;
    private LocalDateTime time;
    private String title;
    private String message;
    private CommentsBean comments;
    private int bloggerID;

    public BlogPost() {
        this.postID = count.incrementAndGet();
        this.time = LocalDateTime.now();
        this.comments = new CommentsBean();
    }

    public BlogPost(Blogger author, String title, String message) {
        this.postID = count.incrementAndGet();
        this.author = author;
        this.title = title;
        this.message = message;
        this.time = LocalDateTime.now();
        this.comments = new CommentsBean();
        this.bloggerID = this.author.getBloggerID();
    }

    public int getPostID() {
        return postID;
    }

    public Blogger getAuthor() {
        return author;
    }

    public void setAuthor(Blogger author) {
        this.author = author;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public CommentsBean getComments() {
        return comments;
    }

    public void setComments(CommentsBean comments) {
        this.comments = comments;
    }

    public int getBloggerID() {
        return bloggerID;
    }

    public void setBloggerID(int bloggerID) {
        this.bloggerID = bloggerID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        BlogPost blogPost = (BlogPost) o;

        if (!author.equals(blogPost.author)) {
            return false;
        }
        if (!time.equals(blogPost.time)) {
            return false;
        }
        if (!title.equals(blogPost.title)) {
            return false;
        }
        return message.equals(blogPost.message);
    }

    @Override
    public int hashCode() {
        int result = author.hashCode();
        result = 31 * result + time.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + message.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "BlogPost{" +
                "postID=" + postID +
                ", author=" + author +
                ", time=" + time +
                ", title='" + title + '\'' +
                ", message='" + message + '\'' +
                ", comments=" + comments +
                '}';
    }
}
