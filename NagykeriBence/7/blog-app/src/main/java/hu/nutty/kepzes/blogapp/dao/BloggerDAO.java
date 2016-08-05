package hu.nutty.kepzes.blogapp.dao;

import hu.nutty.kepzes.blogapp.beans.Blogger;

import java.util.List;

/**
 * Created by Nutty on 2016.07.25..
 */
public interface BloggerDAO {
    Blogger getBloggerByNickName(String nickname);
    Blogger getBloggerById(int bloggerID);
    List<Blogger> getAllBloggers();
    void addBlogger(Blogger blogger);
    void updateBlogger(Blogger blogger);
    void deleteBlogger(Blogger blogger);
}
