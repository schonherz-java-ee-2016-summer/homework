package hu.training.homework.simpleblog.controller;

import hu.training.homework.simpleblog.dao.CommentDAO;
import hu.training.homework.simpleblog.dao.PostDAO;
import hu.training.homework.simpleblog.model.Comment;
import hu.training.homework.simpleblog.model.Post;
import hu.training.homework.simpleblog.util.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostDAO postDAO;
    @Autowired
    private CommentDAO commentDAO;

    @RequestMapping(method = RequestMethod.GET)
    public String showPost(@RequestParam String id, ModelMap modelMap) {
        Post selectedPost = postDAO.getPostByID(id);
        List<Comment> commentsOfPost = commentDAO.getCommentsOfPost(id);
        selectedPost.setComments(commentsOfPost);
        modelMap.addAttribute(Parameters.POST_MODELATTRIBUTE_NAME, selectedPost);
        modelMap.addAttribute(Parameters.NEW_COMMENT_INPUT_NAME, new Comment(id));
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
        postDAO.addPost(post);
        return "redirect:/index";
    }

}
