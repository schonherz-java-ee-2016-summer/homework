package hu.schonherz.traning.homeworkseven.dao.dao;

import hu.schonherz.traning.homeworkseven.dao.pojo.Post;

import java.util.Date;
import java.util.List;

/**
 * Created by Mindfield on 2016. 07. 31..
 */
public interface PostDao {

    List<Post> getAllPost();

    Post getPostById(int identity);

    void createPost(String creator, String title, String text);
}
