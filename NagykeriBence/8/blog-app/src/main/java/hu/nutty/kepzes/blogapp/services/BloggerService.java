package hu.nutty.kepzes.blogapp.services;

import hu.nutty.kepzes.blogapp.dto.BloggerDTO;

/**
 * Created by Nutty on 2016.08.06..
 */
public interface BloggerService {
    BloggerDTO findBloggerByNickName(String nickName);
    void createBlogger(BloggerDTO bloggerDTO);
}
