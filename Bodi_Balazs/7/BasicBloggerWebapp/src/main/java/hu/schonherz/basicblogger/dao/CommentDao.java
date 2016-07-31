package hu.schonherz.basicblogger.dao;

import hu.schonherz.basicblogger.pojo.Comment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bmbal on 2016. 07. 30..
 * private int id;
 private String author;
 private LocalDateTime date;
 private String content;
 */
public class CommentDao {

    public List<Comment> getCommentsForABlog(){
        List<Comment> result = new ArrayList<>();
        return  result;
    }
}
