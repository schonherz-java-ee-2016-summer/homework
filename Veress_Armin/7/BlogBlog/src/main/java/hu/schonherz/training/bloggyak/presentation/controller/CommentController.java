package hu.schonherz.training.bloggyak.presentation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import hu.schonherz.training.bloggyak.data.dao.CommentDAO;
import hu.schonherz.training.bloggyak.data.pojo.Comment;
import hu.schonherz.training.bloggyak.utils.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Lenovo on 2016.07.31..
 */
@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentDAO commentDAO;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addComment(@ModelAttribute(Parameters.NEW_COMMENT) Comment comment, ModelMap modelMap) {
        commentDAO.save(comment);
        return "redirect:/post?id=" + comment.getPostId();
    }

}