package hu.nutty.kepzes.blogapp.entities;

import hu.nutty.kepzes.blogapp.dto.BlogPostDTO;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * Encapsulation of a blog post.
 * Instances of this class contain information about who posted the blog post
 * and of course, the contents of the post itself.
 */
@Entity
@Table(name = "BlogPosts")
public class BlogPostEntity extends BaseEntity implements EntityConverter {

    private static final long serialVersionUID = -114946219811259385L;

    @ManyToOne(cascade = CascadeType.ALL)
    private BloggerEntity author;
    private Timestamp time;
    private String title;
    @Lob
    private String message;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "blog_id")
    private List<CommentEntity> comments;

    public BlogPostEntity() {
    }

    public BlogPostEntity(BloggerEntity author, Timestamp time, String title, String message, List<CommentEntity> comments) {
        this.author = author;
        this.time = time;
        this.title = title;
        this.message = message;
        this.comments = comments;
    }

    @Override
    public BlogPostDTO toDTO() {
        return new BlogPostDTO(this.getId().intValue(), this.author.toDTO(), this.time.toLocalDateTime(), this.title, this.message);
    }

    public BloggerEntity getAuthor() {
        return author;
    }

    public void setAuthor(BloggerEntity author) {
        this.author = author;
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

}
