package hu.training.homework.springblog.controller;

import hu.training.homework.springblog.model.Post;
import hu.training.homework.springblog.repository.CommentDAO;
import hu.training.homework.springblog.model.Comment;
import hu.training.homework.springblog.service.CommentService;
import hu.training.homework.springblog.service.PostService;
import hu.training.homework.springblog.util.Parameters;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    public String addComment(@RequestParam("id") String postId,
                             @ModelAttribute(Parameters.NEW_COMMENT_INPUT_NAME) Comment comment, ModelMap modelMap) {
        commentService.addComment(comment);
        Post post = postService.getPostByID(postId);
        post.getComments().add(comment);
        return "redirect:/post?id=" + postId;
    }

}
