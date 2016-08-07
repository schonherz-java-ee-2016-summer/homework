package hu.training.homework.springblog.controller;

import hu.training.homework.springblog.model.Post;
import hu.training.homework.springblog.model.Comment;
import hu.training.homework.springblog.service.PostService;
import hu.training.homework.springblog.util.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private PostService postService;

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String addComment(@RequestParam("id") String postId,
                             @ModelAttribute(Parameters.NEW_COMMENT_INPUT_NAME) Comment comment, ModelMap modelMap) {
        Post post = postService.getPostByID(postId);
        post.getComments().add(comment);
        postService.addPost(post);
        return "redirect:/post?id=" + postId;
    }

}
