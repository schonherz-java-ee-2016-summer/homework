package hu.schonherz.training.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Attila on 2016.07.19..
 */
public class PostsList {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostsList.class);
    private List<Post> postsList = new ArrayList<Post>();

    {
        postsList.add(new Post(0, "Attila", "2016-05-20", "NFL", "What a match was it!"));
        postsList.add(new Post(1, "Béla", "2016-05-12", "NFL", "What a match was it!"));
    }

    public List<Post> getPostsList() {
        return postsList;
    }

    public Post getPost(Integer integer){
        for (Post post: postsList){
            if (post.getPostID() == integer){
                return post;
            }
        }
        return new Post();
    }
}
