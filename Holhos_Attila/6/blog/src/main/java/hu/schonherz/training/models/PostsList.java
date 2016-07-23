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

    /*public static void writePostsToFile(){
        try (FileOutputStream out = new FileOutputStream("Posts.txt")) {
            ObjectOutputStream oout = new ObjectOutputStream(out);
            oout.writeObject(postsList);
            oout.flush();
        } catch (IOException e){
            LOGGER.error("IOException");
        }
    }

    public static void readPostsFromFile(){
        File file = new File("Posts.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e){
                LOGGER.error("File was not created!");
            }
        } else {
            try (FileInputStream in = new FileInputStream(file)) {
                ObjectInputStream oin = new ObjectInputStream(in);
                postsList = ((List<Post>) oin.readObject());
                System.out.println(postsList.get(0).getAuthor());
            } catch (ClassNotFoundException e) {
                LOGGER.error("Class not found exception");
            } catch (IOException e) {
                LOGGER.error("IOException at reading posts!");
            }
        }
    }*/
}
