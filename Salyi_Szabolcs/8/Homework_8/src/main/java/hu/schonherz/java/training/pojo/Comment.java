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
    private String comment;

    public Comment() {
    }

    public String getContent() {
        return comment;
    }

    public void setContent(String content) {
        this.comment = content;
    }
}
