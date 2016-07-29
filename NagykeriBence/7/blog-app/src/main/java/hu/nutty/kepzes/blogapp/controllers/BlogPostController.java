package hu.nutty.kepzes.blogapp.controllers;

import hu.nutty.kepzes.blogapp.beans.BlogPost;
import hu.nutty.kepzes.blogapp.beans.Blogger;
import hu.nutty.kepzes.blogapp.beans.CommentsBean;
import hu.nutty.kepzes.blogapp.dao.BlogPostDAO;
import hu.nutty.kepzes.blogapp.dao.BloggerDAO;
import hu.nutty.kepzes.blogapp.dao.CommentDAO;
import hu.nutty.kepzes.blogapp.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
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
        return "newpost";
    }

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public String selectAndDisplayPostById(ModelMap model, HttpServletRequest req) {
        int postID = Integer.parseInt(req.getParameter("p"));
        BlogPost selectedPost = blogPostDAO.getBlogPostById(postID);
        Blogger author = bloggerDAO.getBloggerById(selectedPost.getBloggerID());
        selectedPost.setAuthor(author);
        CommentsBean comments = new CommentsBean();
        comments.setComments(commentDAO.getCommentsByPostId(postID));
        selectedPost.setComments(comments);
        model.addAttribute(Constants.SELECTED_POST, selectedPost);
        req.getSession().setAttribute(Constants.SELECTED_POST, selectedPost);
        return "posts";
    }

}
