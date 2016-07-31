package hu.schonherz.basicblogger.dao;

import hu.schonherz.basicblogger.pojo.Blog;

import java.util.List;

/**
 * Created by bmbal on 2016. 07. 30..
 *  this.id = id;
 this.author = author;
 this.date = date;
 this.title = title;
 this.content = content;
 */
public interface BlogDao {

    public Blog getBlogById(int id);

    public List<Blog> getAllBlog();

    public void createBlog(Blog blog);

}
