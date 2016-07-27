package hu.schonherz.java.training.blog12.data.post;

import hu.schonherz.java.training.blog12.data.comment.Comment;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Home on 2016. 07. 18..
 */

/**
 * Instance of this class contain information about
 * the id , author, date, title, content and the comments of the post.
 */
public class Post implements Serializable {

    private int id;
    private String author;
    private LocalDateTime date;
    private String title;
    private String content;
    private List<Comment> comments;

    private Post(PostBuilder builder) {
        this.id = builder.id;
        this.author = builder.author;
        this.date = builder.date;
        this.title = builder.title;
        this.content = builder.content;
        this.comments = builder.comments;

    }

    public int getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public static class PostBuilder {
        private final int id;
        private final String author;
        private final String title;
        private LocalDateTime date ;
        private String content;
        private List<Comment> comments = new ArrayList<>();

        public PostBuilder(Integer id, String author, String title) {
            this.id=id;
            this.author = author;
            this.title = title;
        }

        public PostBuilder content(String content){
            this.content = content;
            return this;
        }

        public PostBuilder comments(List<Comment> comments){
            this.comments = comments;
            return this;
        }

        public PostBuilder date(LocalDateTime date){
            this.date=date;
            return this;
        }

        public Post build() {

            return new Post(this);
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Post post = (Post) o;

        if (id != 0 ? getId() != post.getId() : post.getId() != 0 ) {
            return false;
        }

        return getContent() != null ? getContent().equals(post.getContent()) : post.getContent() != null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + author.hashCode();
        result = 31 * result + date.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + content.hashCode();
        result = 31 * result + comments.hashCode();
        return result;
    }
}
