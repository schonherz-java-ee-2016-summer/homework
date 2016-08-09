package hu.nutty.kepzes.blogapp.services;

import hu.nutty.kepzes.blogapp.dto.BloggerDTO;

/**
 * Created by Nutty on 2016.08.06..
 */
public interface BloggerService {
    BloggerDTO getBloggerById(Long id);
    Long createBlogger(BloggerDTO bloggerDTO);
}
