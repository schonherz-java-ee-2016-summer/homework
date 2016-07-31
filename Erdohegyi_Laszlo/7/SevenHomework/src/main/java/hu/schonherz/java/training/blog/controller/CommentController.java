package hu.schonherz.java.training.blog.controller;

import hu.schonherz.java.training.blog.dao.CommentDao;
import hu.schonherz.java.training.blog.model.BlogComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/showpost/*")
public class CommentController {

    @Autowired
    private CommentDao commentDao;

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String addComment(@ModelAttribute("newcomment") BlogComment comment, ModelMap modelMap) {
        commentDao.createComment(comment.getPostId(), comment.getContent());
        return "redirect:/post/" + comment.getPostId();
    }

}