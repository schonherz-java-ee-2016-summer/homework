package hu.schonherz.training.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Roli on 2016. 08. 07..
 */
public class CommentVo implements Serializable {

    private static final long serialVersionUID = 687688758L;

    private Long id;
    private Long blogid;
    private Date date;
    private String content;

    public CommentVo() {
        this.date = new Date();
    }

    public Long getId() {
        return id;
    }

    public Long getBlogid() {
        return blogid;
    }

    public void setBlogid(Long blogid) {
        this.blogid = blogid;
    }

    public void setId(Long id) {
        this.id = id;
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
