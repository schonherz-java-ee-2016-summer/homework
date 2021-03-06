package hu.training.homework.simpleblog.controller;

import hu.training.homework.simpleblog.dao.CommentDAO;
import hu.training.homework.simpleblog.model.Comment;
import hu.training.homework.simpleblog.util.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentDAO commentDAO;

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String addComment(@ModelAttribute(Parameters.NEW_COMMENT_INPUT_NAME) Comment comment, ModelMap modelMap) {
        commentDAO.addComment(comment);
        return "redirect:/post?id=" + comment.getPostID();
    }

}
