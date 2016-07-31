package hu.schonherz.training.bloggyak.presentation.controller;

import hu.schonherz.training.bloggyak.data.pojo.Post;
import hu.schonherz.training.bloggyak.data.pojo.CommentBean;
import hu.schonherz.training.bloggyak.data.dao.PostDAO;
import hu.schonherz.training.bloggyak.data.dao.CommentDAO;
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
import org.springframework.web.bind.annotation.RequestParam;
import hu.schonherz.training.bloggyak.data.pojo.Comment;
import hu.schonherz.training.bloggyak.utils.Parameters;

/**
 * Created by Lenovo on 2016.07.31..
 */

@Controller
public class PostController {

    @Autowired
    private PostDAO blogPostDAO;
    @Autowired
    private CommentDAO commentDAO;

    @RequestMapping(value = "/post/new", method = RequestMethod.GET)
    public String newPostForm(ModelMap model) {
        return "newpost";
    }

    @RequestMapping(value = "/posts", method = RequestMethod.GET)
    public String displayPostById(ModelMap model, HttpServletRequest req) {
        int postID = Integer.parseInt(req.getParameter("p"));
        Post selectedPost = blogPostDAO.findById(postID);
        selectedPost.setAuthor(req.getParameter(Parameters.POST_AUTHOR));
        CommentBean comments = new CommentBean();
        comments.setComments(commentDAO.findAllByPostId(postID));
        selectedPost.setComments(comments);
        model.addAttribute(Parameters.SELECTED_POST, selectedPost);
        req.getSession().setAttribute(Parameters.SELECTED_POST, selectedPost);
        return "posts";
    }
}