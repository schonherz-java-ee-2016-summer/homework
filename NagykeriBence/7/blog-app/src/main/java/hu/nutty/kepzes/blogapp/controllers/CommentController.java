package hu.nutty.kepzes.blogapp.controllers;

import com.sun.xml.internal.bind.v2.runtime.reflect.opt.Const;
import hu.nutty.kepzes.blogapp.beans.BlogPost;
import hu.nutty.kepzes.blogapp.beans.Comment;
import hu.nutty.kepzes.blogapp.dao.CommentDAO;
import hu.nutty.kepzes.blogapp.utils.Constants;
import hu.nutty.kepzes.blogapp.utils.ParserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Nutty on 2016.07.29..
 */
@Controller

public class CommentController {
    @Autowired
    CommentDAO commentDAO;

    @RequestMapping(value = "/comment/new", method = RequestMethod.GET)
    public String displayNewPost(ModelMap model) {
        return "newcomment";
    }

    @RequestMapping(value = "/" + Constants.COMMENTS_KEY, method = RequestMethod.POST)
    public String handleNewComment(ModelMap model, HttpServletRequest req) {
        Comment comment = ParserUtils.parseBodyAsComment(req);
        BlogPost selectedPost = (BlogPost) req.getSession().getAttribute(Constants.SELECTED_POST);
        comment.setBlogPostID(selectedPost.getPostID());
        commentDAO.addComment(comment);
        selectedPost.getComments().addComment(comment);

        return "posts";
    }
}
