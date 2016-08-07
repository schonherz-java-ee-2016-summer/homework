package hu.nutty.kepzes.blogapp.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple Java Bean encapsulating a number of "blog posts".
 */
public class BlogPostsBean implements Serializable {

    private static final long serialVersionUID = 3515926025571709013L;

    private List<BlogPostDTO> posts = new ArrayList<>();

    public List<BlogPostDTO> getPosts() {
        return posts;
    }

    public void setPosts(final List<BlogPostDTO> posts) {
        this.posts = posts;
    }

    public void addPost(BlogPostDTO post) {
        this.posts.add(post);
    }

}
