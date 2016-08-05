package hu.schonherz.training.dao;

import java.util.List;

import hu.schonherz.training.pojo.Blog;

/**
 * Created by Roli on 2016. 07. 28..
 */
public interface BlogDao {

    public List<Blog> getAllBlog();

    public Blog getBlogById(int id);

    public void addBlog(Blog blog);

}
