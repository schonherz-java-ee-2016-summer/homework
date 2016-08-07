package hu.schonherz.basicblogger.service;

import hu.schonherz.basicblogger.entity.Blog;

import java.util.List;

/**
 * Created by bmbal on 2016.08.06..
 */
interface BlogService {

    List<Blog> getAllBlog();

    Blog getBlogById(Long id);

    public void createBlog(Blog blog);

}
