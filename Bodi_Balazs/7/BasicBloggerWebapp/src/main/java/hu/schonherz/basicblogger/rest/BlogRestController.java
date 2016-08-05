package hu.schonherz.basicblogger.rest;

import hu.schonherz.basicblogger.jdbcTemplates.BlogJDBCTemplate;
import hu.schonherz.basicblogger.pojo.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by bmbal on 2016. 07. 31..
 */
@RestController
@RequestMapping(path = "/", produces = "application/json")
public class BlogRestController {

    @Autowired
    private BlogJDBCTemplate blogJDBCTemplate;

    @RequestMapping(path = "/createblog", method = RequestMethod.POST)
    public ResponseEntity createBlog(@RequestBody Blog blog) {
        blogJDBCTemplate.createBlog(blog);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(path = "/blogs", method = RequestMethod.GET)
    public ResponseEntity getAllBlogs(Model model) {
        List<Blog> blogs = blogJDBCTemplate.getAllBlog();
        return new ResponseEntity(blogs, HttpStatus.OK);
    }
}
