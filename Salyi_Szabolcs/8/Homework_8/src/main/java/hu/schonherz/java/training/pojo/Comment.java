package hu.schonherz.java.training.pojo;

import hu.schonherz.java.training.entity.BaseEntity;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Home on 2016. 08. 03..
 */

@Entity
@Table(name = "Comment")
public class Comment extends BaseEntity{

    private static final long serialVersionIUD = 1L;

    @Basic
    private Long blog_id;

    @Basic
    private String content;

    public Comment() {
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getBlog_id() {
        return blog_id;
    }

    public void setBlog_id(Long blog_id) {
        this.blog_id = blog_id;
    }
}
