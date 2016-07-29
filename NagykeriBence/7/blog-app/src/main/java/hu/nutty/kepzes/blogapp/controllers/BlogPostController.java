package hu.nutty.kepzes.blogapp.controllers;

import hu.nutty.kepzes.blogapp.beans.BlogPost;
import hu.nutty.kepzes.blogapp.dao.BlogPostDAO;
import hu.nutty.kepzes.blogapp.dao.BloggerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import static hu.nutty.kepzes.blogapp.utils.Constants.INDEX_KEY;


@Controller
public class BlogPostController {

    @RequestMapping(value = "/post/new", method = RequestMethod.GET)
    public String displayNewPost(ModelMap model) {
        return "newpost";
    }

}
