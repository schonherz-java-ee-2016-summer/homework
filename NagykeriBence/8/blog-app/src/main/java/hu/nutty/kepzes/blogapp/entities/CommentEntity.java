package hu.nutty.kepzes.blogapp.entities;

import hu.nutty.kepzes.blogapp.dto.CommentDTO;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.Table;
import java.sql.Timestamp;


/**
 * Encapsulation of a comment.
 * Instances of this class contain information about who posted the comment
 * and of course, the contents of the comment itself.
 */
@Entity
@Table(name = "Comments")
public class CommentEntity extends BaseEntity {
    private static final long serialVersionUID = 6245145615416L;

    private String commenter;
    @Lob
    private String content;
    private Timestamp time;

    public CommentEntity() {
    }

    public CommentEntity(String commenter, String content, Timestamp time) {
        this.commenter = commenter;
        this.content = content;
        this.time = time;
    }

    public CommentDTO toDTO() {
        return new CommentDTO(this.getId().intValue(), this.commenter, this.content, this.time.toLocalDateTime());
    }

    public String getCommenter() {
        return commenter;
    }

    public void setCommenter(final String commenter) {
        this.commenter = commenter;
    }

    public String getContent() {
        return content;
    }

    public void setContent(final String content) {
        this.content = content;
    }

}
