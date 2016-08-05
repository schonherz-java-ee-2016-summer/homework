package hu.nutty.kepzes.blogapp.rest;

import hu.nutty.kepzes.blogapp.beans.BlogPost;
import hu.nutty.kepzes.blogapp.dao.BlogPostDAO;
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
 * Created by Nutty on 2016.07.26..
 */

@RestController()
@RequestMapping(path = "/api/blogs", produces = "application/json")
public class RestBlogPostController {
    @Autowired
    private BlogPostDAO blogPostDAO;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity listBlogPosts(Model model) {
        List<BlogPost> blogs = blogPostDAO.getAllBlogPosts();
        return new ResponseEntity(blogs, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addBlogPost(@RequestBody BlogPost blog) {
        blogPostDAO.addBlogPost(blog);
        return new ResponseEntity(HttpStatus.OK);
    }
}

