package hu.nutty.kepzes.blogapp.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple Java Bean encapsulating a number of "blog posts".
 */
public class BlogPostsBean implements Serializable {

    private static final long serialVersionUID = 3515926025571709013L;

    private List<BlogPost> posts = new ArrayList<>();

    public List<BlogPost> getPosts() {
        return posts;
    }

    public void setPosts(final List<BlogPost> posts) {
        this.posts = posts;
    }

}
