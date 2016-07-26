package hu.schonherz.java.training.blog12.data.post;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Home on 2016. 07. 18..
 */

/**
 * Simple Java Bean encapsulating a number of comments.
 */
public class PostBean implements Serializable {

    private static List<Post> posts = new ArrayList<>();

    public static List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
