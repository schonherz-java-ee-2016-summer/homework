package hu.training.homework.springblog.controller;

import hu.training.homework.springblog.model.Post;
import hu.training.homework.springblog.repository.CommentDAO;
import hu.training.homework.springblog.model.Comment;
import hu.training.homework.springblog.service.CommentService;
import hu.training.homework.springblog.service.PostService;
import hu.training.homework.springblog.util.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/comment")
public class CommentController {

    /*@Autowired
    private CommentDAO commentDAO;*/
    @Autowired
    private PostService postService;
    @Autowired
    private CommentService commentService;

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String addComment(@ModelAttribute(Parameters.POST_MODELATTRIBUTE_NAME) Post post,
                             @ModelAttribute(Parameters.COMMENT_INPUT_NAME) Comment comment, ModelMap modelMap) {
        post.getComments().add(comment);
        return "redirect:/post?id=" + post.getId();
    }

}
