package hu.nutty.kepzes.blogapp.dao;

import hu.nutty.kepzes.blogapp.dto.BloggerDTO;

import java.util.List;

/**
 * Created by Nutty on 2016.07.25..
 */
public interface BloggerDAO {
    BloggerDTO getBloggerByNickName(String nickname);

    BloggerDTO getBloggerById(int bloggerID);

    List<BloggerDTO> getAllBloggers();

    void addBlogger(BloggerDTO blogger);

    int addBloggerAndReturnId(BloggerDTO blogger);

    void updateBlogger(BloggerDTO blogger);

    void deleteBlogger(BloggerDTO blogger);
}
