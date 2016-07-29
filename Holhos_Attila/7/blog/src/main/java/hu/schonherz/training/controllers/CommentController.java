package hu.schonherz.training.controllers;

import hu.schonherz.training.dao.CommentDao;
import hu.schonherz.training.models.Comment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger LOG = LoggerFactory.getLogger(CommentController.class);

    @Autowired
    private CommentDao commentDao;

    @RequestMapping(path = "/new", method = RequestMethod.POST)
    public String addcomment(@ModelAttribute("comment") Comment comment, Model model){
        commentDao.createComment(comment.getPostID(), comment);
        LOG.info("A comment was added to post " + comment.getPostID() + "!");
        return ("redirect:/post/" + comment.getPostID());
    }
}
