package hu.training.homework.simpleblog.controller;

import hu.training.homework.simpleblog.model.Comment;
import hu.training.homework.simpleblog.model.Post;
import hu.training.homework.simpleblog.util.Parameters;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public ModelAndView addComment(
            @ModelAttribute(Parameters.COMMENTS_ATTRIBUTE_NAME) List<Comment> comments, ModelMap modelMap) {

        /*modelMap.addAttribute(Parameters.COMMENT_INPUT_NAME, comment);
        return new ModelAndView("post", "command", comment);*/
    }

}
