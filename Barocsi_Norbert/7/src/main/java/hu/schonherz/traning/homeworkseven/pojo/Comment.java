package hu.schonherz.traning.homeworkseven.pojo;

import java.time.LocalDateTime;

/**
 * Created by Mindfield on 2016. 07. 31..
 */
public class Comment {

    private int identity;
    private int blogIdentity;
    private LocalDateTime date;
    private String content;

    public Comment() {
    }

    public Comment(int blogIdentity) {
        this.blogIdentity = blogIdentity;
    }
    public int getIdentity() {
        return identity;
    }

    public void setIdentity(int identity) {
        this.identity = identity;
    }

    public int getBlogIdentity() {
        return blogIdentity;
    }

    public void setBlogIdentity(int blogidentity) {
        this.blogIdentity = blogidentity;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
