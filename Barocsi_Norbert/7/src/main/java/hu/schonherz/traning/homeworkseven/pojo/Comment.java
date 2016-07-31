package hu.schonherz.traning.homeworkseven.dao.pojo;

import java.util.Date;

/**
 * Created by Mindfield on 2016. 07. 31..
 */
public class Comment {

    private int identity;
    private int blogIdentity;
    private Date date;
    private String content;

    public Comment() {
    }

    public int getIdentity() {
        return identity;
    }

    public void setIdentity(int identity) {
        this.identity = identity;
    }

    public int getBlog_identity() {
        return blogIdentity;
    }

    public void setBlog_identity(int blog_identity) {
        this.blogIdentity = blog_identity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
