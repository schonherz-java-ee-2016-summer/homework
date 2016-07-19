package hu.schonherz.java.training.blog.data.post;

import hu.schonherz.java.training.blog.data.comment.CommentsBean;

import java.io.Serializable;
import java.text.SimpleDateFormat;

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
    private SimpleDateFormat date = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
    private String title;
    private String content;
    private CommentsBean comments;

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

    public CommentsBean getComments() {
        return comments;
    }

    public SimpleDateFormat getDate() {
        return date;
    }

    public static class PostBuilder {
        private final int id;
        private final String author;
        private final String title;
        private SimpleDateFormat date = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
        private String content;
        private CommentsBean comments;

        public PostBuilder(int id, String author, String title) {
            this.id = id;
            this.author = author;
            this.title = title;
        }

        public PostBuilder content(String content){
            this.content = content;
            return this;
        }

        public PostBuilder comments(CommentsBean comments){
            this.comments = comments;
            return this;
        }

        public Post bulid() {
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
