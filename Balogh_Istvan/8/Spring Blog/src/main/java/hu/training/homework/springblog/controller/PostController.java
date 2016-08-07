package hu.training.homework.springblog.controller;

import hu.training.homework.springblog.model.Comment;
import hu.training.homework.springblog.model.Post;
import hu.training.homework.springblog.service.PostService;
import hu.training.homework.springblog.util.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping(method = RequestMethod.GET)
    public String showPost(@RequestParam String id, ModelMap modelMap) {
        Post selectedPost = postService.getPostByID(id);
        modelMap.addAttribute(Parameters.POST_MODELATTRIBUTE_NAME, selectedPost);
        modelMap.addAttribute(Parameters.NEW_COMMENT_INPUT_NAME, new Comment());
        return "post";
    }

    @RequestMapping(path = "/new", method = RequestMethod.GET)
    public ModelAndView createPost(ModelMap modelMap) {
        Post post = new Post();
        modelMap.addAttribute(Parameters.POST_MODELATTRIBUTE_NAME, post);
        return new ModelAndView("newBlogPost", "command", post);
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public String createPost(@ModelAttribute("post") Post post, ModelMap modelMap) {
        postService.addPost(post);
        return "redirect:/index";
    }

}
