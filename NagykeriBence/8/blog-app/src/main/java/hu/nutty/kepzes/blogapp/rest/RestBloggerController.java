package hu.nutty.kepzes.blogapp.rest;

import hu.nutty.kepzes.blogapp.beans.BlogPost;
import hu.nutty.kepzes.blogapp.beans.Blogger;
import hu.nutty.kepzes.blogapp.dao.BlogPostDAO;
import hu.nutty.kepzes.blogapp.dao.BloggerDAO;
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
@RequestMapping(path = "/api/bloggers", produces = "application/json")
public class RestBloggerController {
    @Autowired
    private BloggerDAO bloggerDAO;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity listBloggers(Model model) {
        List<Blogger> bloggers = bloggerDAO.getAllBloggers();
        return new ResponseEntity(bloggers, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addBlogger(@RequestBody Blogger blogger) {
        bloggerDAO.addBlogger(blogger);
        return new ResponseEntity(HttpStatus.OK);
    }
}

