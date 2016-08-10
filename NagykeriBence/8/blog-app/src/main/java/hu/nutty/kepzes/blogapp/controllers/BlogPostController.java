package hu.nutty.kepzes.blogapp.controllers;

import hu.nutty.kepzes.blogapp.dto.BlogPostDTO;
import hu.nutty.kepzes.blogapp.dto.BloggerDTO;
import hu.nutty.kepzes.blogapp.dto.CommentsBean;
import hu.nutty.kepzes.blogapp.dao.BlogPostDAO;
import hu.nutty.kepzes.blogapp.dao.BloggerDAO;
import hu.nutty.kepzes.blogapp.dao.CommentDAO;
import hu.nutty.kepzes.blogapp.services.BlogPostService;
import hu.nutty.kepzes.blogapp.services.BloggerService;
import hu.nutty.kepzes.blogapp.services.CommentService;
import hu.nutty.kepzes.blogapp.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class BlogPostController {
    @Autowired
    private BlogPostService blogPostService;
    @Autowired
    private CommentService commentService;

    @RequestMapping(value = "/post/new", method = RequestMethod.GET)
    public String displayNewPost(ModelMap model) {
        BloggerDTO blogger = new BloggerDTO();
        BlogPostDTO blogPost = new BlogPostDTO();
        model.addAttribute("blogger", blogger);
        model.addAttribute("blogPost", blogPost);
        return "newpost";
    }

    @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
    public String selectAndDisplayPostById(ModelMap model, @PathVariable Long id) {
        BlogPostDTO selectedPost = blogPostService.getBlogPostById(id);
        model.addAttribute(Constants.SELECTED_POST, selectedPost);
        return "posts";
    }

}
