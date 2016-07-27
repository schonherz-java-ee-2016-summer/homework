package hu.training.homework.simpleblog.controller;

import hu.training.homework.simpleblog.dao.PostDAO;
import hu.training.homework.simpleblog.model.Post;
import hu.training.homework.simpleblog.util.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostDAO dao;

    /*@RequestMapping(path = "/new", method = RequestMethod.GET)
    public String newPost() {
        return "newBlogPost";
    }*/

    @RequestMapping(path = "/new", method = RequestMethod.GET)
    public ModelAndView createPost(ModelMap modelMap) {
        Post post = new Post();
        modelMap.addAttribute(Parameters.POST_MODELATTRIBUTE_NAME, post);
        modelMap.addAttribute(Parameters.COMMENTS_ATTRIBUTE_NAME, post.getComments());
        return new ModelAndView("newBlogPost", "command", post);
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public String createPost(@ModelAttribute("post") Post post, ModelMap modelMap) {
        dao.addPost(post);
        return "post";
    }

}
