package hu.schonherz.traning.homeworksix.pojo;

import java.time.LocalDateTime;

/**
 * Created by Mindfield on 2016. 07. 21..
 */
public class BlogComment {
    //id, kommentelés dátuma, tartalom
    private int identity;
    private LocalDateTime commentDate;
    private String content;

    public BlogComment(int identity, LocalDateTime commentDate, String content) {
        this.identity = identity;
        this.commentDate = commentDate;
        this.content = content;
    }

    public int getIdentity() {
        return identity;
    }

    public LocalDateTime getCommentDate() {
        return commentDate;
    }

    public String getContent() {
        return content;
    }
}
