package hu.schonherz.training.bloggyak.data.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2016.07.31..
 */

public class PostBean implements Serializable {

    private List<Post> posts = new ArrayList<>();

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(final List<Post> posts) {
        this.posts = posts;
    }

    public void addPost(Post post) {
        this.posts.add(post);
    }

}
