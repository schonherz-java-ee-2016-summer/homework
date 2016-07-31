package hu.schonherz.traning.homeworkseven.dao.pojo;

import java.util.Date;

/**
 * Created by Mindfield on 2016. 07. 31..
 */
public class Post {

    private int identity;
    private String creator;
    private Date date;
    private String title;
    private String text;

    public Post() {
    }

    public int getIdentity() {
        return identity;
    }

    public void setIdentity(int identity) {
        this.identity = identity;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
