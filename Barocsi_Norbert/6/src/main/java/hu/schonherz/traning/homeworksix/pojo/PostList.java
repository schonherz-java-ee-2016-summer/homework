package hu.schonherz.traning.homeworksix.pojo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mindfield on 2016. 07. 24..
 */
public class PostList {
    private static List<BlogPost> postsList = new ArrayList<>();

    public static List<BlogPost> getPostsList(){
        return postsList;
    }



}
