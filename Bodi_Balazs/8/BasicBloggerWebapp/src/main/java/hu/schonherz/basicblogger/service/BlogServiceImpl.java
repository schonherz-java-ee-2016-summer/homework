package hu.schonherz.basicblogger.service;

import hu.schonherz.basicblogger.entity.Blog;
import hu.schonherz.basicblogger.dao.BlogDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by bmbal on 2016.08.06..
 */
@Service
public class BlogServiceImpl implements BlogService{

    @Autowired
    private BlogDao blogDao;

    @Override
    public List<Blog> getAllBlog() {
        List<Blog> blogs = blogDao.findAll();
        return blogs;
    }

    @Override
    public Blog getBlogById(Long id) {
        Blog blog = blogDao.findById(id);
        return blog;
    }

    @Override
    public void createBlog(Blog blog) {
        blogDao.save(blog);
    }
}
