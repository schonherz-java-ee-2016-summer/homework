package hu.schonherz.training.controllers;

import hu.schonherz.training.dao.CommentDao;
import hu.schonherz.training.models.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Attila on 2016.07.29..
 */

@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentDao commentDao;

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String addcomment(@ModelAttribute("comment") Comment comment, Model model){
        commentDao.createComment(comment.getPostID(),comment);
        return ("redirect:/post/" + comment.getPostID());
    }
}
