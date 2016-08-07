package hu.nutty.kepzes.blogapp.controllers;

import hu.nutty.kepzes.blogapp.dto.BlogPostDTO;
import hu.nutty.kepzes.blogapp.dto.BloggerDTO;
import hu.nutty.kepzes.blogapp.dto.CommentsBean;
import hu.nutty.kepzes.blogapp.dao.BlogPostDAO;
import hu.nutty.kepzes.blogapp.dao.BloggerDAO;
import hu.nutty.kepzes.blogapp.dao.CommentDAO;
import hu.nutty.kepzes.blogapp.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

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
        BloggerDTO blogger = new BloggerDTO();
        BlogPostDTO blogPost = new BlogPostDTO();
        model.addAttribute("blogger", blogger);
        model.addAttribute("blogPost", blogPost);
        return "newpost";
    }

    @RequestMapping(value = "/post/{id}", method = RequestMethod.GET)
    public String selectAndDisplayPostById(ModelMap model, @PathVariable int id) {
        BlogPostDTO selectedPost = blogPostDAO.getBlogPostById(id);
        BloggerDTO author = bloggerDAO.getBloggerById(selectedPost.getBloggerID());
        selectedPost.setAuthor(author);
        CommentsBean comments = new CommentsBean();
        comments.setComments(commentDAO.getCommentsByPostId(id));
        selectedPost.setComments(comments);
        model.addAttribute(Constants.SELECTED_POST, selectedPost);
        return "posts";
    }

}
