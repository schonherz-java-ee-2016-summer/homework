package hu.nutty.kepzes.blogapp.controllers;

import hu.nutty.kepzes.blogapp.beans.BlogPost;
import hu.nutty.kepzes.blogapp.beans.BlogPostsBean;
import hu.nutty.kepzes.blogapp.dao.implementations.BlogPostDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import static hu.nutty.kepzes.blogapp.utils.Constants.*;

// this is a controller
@Controller
// if a request enter on "/" url then this controller will handle it
@RequestMapping("/")
public class IndexController {
    @Autowired
    private BlogPostDAOImpl blogPostDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String displayIndex(ModelMap model) {
        List<BlogPost> blogs = blogPostDAO.getAllBlogPosts();
        blogs.add(new BlogPost());

        model.addAttribute(INDEX_KEY, blogs);

        return "index";
    }

}
