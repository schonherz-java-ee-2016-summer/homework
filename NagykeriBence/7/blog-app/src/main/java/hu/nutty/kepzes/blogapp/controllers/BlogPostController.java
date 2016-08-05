package hu.nutty.kepzes.blogapp.controllers;

import hu.nutty.kepzes.blogapp.beans.BlogPost;
import hu.nutty.kepzes.blogapp.beans.Blogger;
import hu.nutty.kepzes.blogapp.beans.CommentsBean;
import hu.nutty.kepzes.blogapp.dao.BlogPostDAO;
import hu.nutty.kepzes.blogapp.dao.BloggerDAO;
import hu.nutty.kepzes.blogapp.dao.CommentDAO;
import hu.nutty.kepzes.blogapp.utils.Constants;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static hu.nutty.kepzes.blogapp.utils.Constants.POSTS;

@Controller
public class BlogPostController {
    @Autowired
    private BlogPostDAO blogPostDAO;
    @Autowired
    private BloggerDAO bloggerDAO;
    @Autowired
    private CommentDAO commentDAO;

    @RequestMapping(value = "/post/new", method = RequestMethod.GET)
    public String displayNewPost(ModelMap model) {
        Blogger blogger = new Blogger();
        BlogPost blogPost = new BlogPost();
        model.addAttribute("blogger", blogger);
        model.addAttribute("blogPost", blogPost);
        return "newpost";
    }

    @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
    public String selectAndDisplayPostById(ModelMap model, @PathVariable int id) {
        BlogPost selectedPost = blogPostDAO.getBlogPostById(id);
        Blogger author = bloggerDAO.getBloggerById(selectedPost.getBloggerID());
        selectedPost.setAuthor(author);
        CommentsBean comments = new CommentsBean();
        comments.setComments(commentDAO.getCommentsByPostId(id));
        selectedPost.setComments(comments);
        model.addAttribute(Constants.SELECTED_POST, selectedPost);
        return "posts";
    }

}
