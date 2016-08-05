package hu.schonherz.basicblogger.entity;

import javax.persistence.*;

/**
 * Created by bmbal on 2016.08.05..
 */
@Entity
@Table(name = "Comment")
public class Comment extends BaseEntity{

    @Id
    @JoinColumn(name = "id")
    private int id;

    @Lob
    private int blogId;

    @Lob
    private String author;

    @Lob
    private String content;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
