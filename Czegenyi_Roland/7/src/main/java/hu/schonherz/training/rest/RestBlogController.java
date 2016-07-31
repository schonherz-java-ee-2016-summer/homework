package hu.schonherz.training.rest;

import hu.schonherz.training.dao.impl.BlogDaoImpl;
import hu.schonherz.training.pojo.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Roli on 2016. 07. 31..
 */

@RestController
@RequestMapping(path = "/api/blogs", produces = "application/json")
public class RestBlogController {

    @Autowired
    private BlogDaoImpl blogDao;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity listBlogs() {
        List<Blog> blogs = blogDao.getAllBlog();
        return new ResponseEntity(blogs, HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.POST, path = "/add")
    public ResponseEntity addBlog(@RequestBody Blog blog) {
        blogDao.addBlog(blog);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{blogId}")
    public ResponseEntity getBlog(@PathVariable("blogId") int blogId) {
        Blog blog = blogDao.getBlogById(blogId);
        return new ResponseEntity(blog, HttpStatus.OK);
    }
}
