package hu.nutty.kepzes.blogapp.controllers;

import hu.nutty.kepzes.blogapp.beans.BlogPost;
import hu.nutty.kepzes.blogapp.beans.Comment;
import hu.nutty.kepzes.blogapp.dao.BlogPostDAO;
import hu.nutty.kepzes.blogapp.dao.CommentDAO;
import hu.nutty.kepzes.blogapp.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Nutty on 2016.07.29..
 */
@Controller

public class CommentController {
    @Autowired
    BlogPostDAO blogPostDAO;
    @Autowired
    CommentDAO commentDAO;

    @RequestMapping(value = "/post/{id}/newcomment", method = RequestMethod.GET)
    public ModelAndView displayNewComment(@PathVariable int id) {
        Comment comment = new Comment();
        comment.setBlogPostID(id);
        return new ModelAndView("newcomment", "command", comment);
    }

    @RequestMapping(value = "/" + Constants.COMMENTS_KEY, method = RequestMethod.POST)
    public String handleNewComment(@ModelAttribute Comment comment) {
        BlogPost selectedPost = blogPostDAO.getBlogPostById(comment.getBlogPostID());
        commentDAO.addComment(comment);
        //commentDAO.addCommentAndReturnId(comment);
        selectedPost.getComments().addComment(comment);

        return "redirect:post/" + selectedPost.getPostID();
    }
}
