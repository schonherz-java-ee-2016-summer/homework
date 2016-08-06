package hu.schonherz.training.controller;

import hu.schonherz.training.dao.CommentDao;
import hu.schonherz.training.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Roli on 2016. 07. 31..
 */
@Controller
@RequestMapping(path = "/comment")
public class CommentController {

    @Autowired
    private CommentDao commentDao;

    @RequestMapping(path = "/addComment", method = RequestMethod.POST)
    public String newComment(@ModelAttribute("comment") Comment comment, Model model) {

        commentDao.save(comment);
        commentDao.flush();
        return "redirect:/blog/id=" + comment.getId();

    }
}
