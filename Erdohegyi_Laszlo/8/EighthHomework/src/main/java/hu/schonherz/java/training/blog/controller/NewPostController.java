package hu.schonherz.java.training.blog.controller;

import hu.schonherz.java.training.blog.dao.PostDao;
import hu.schonherz.java.training.blog.entity.BlogPost;
import hu.schonherz.java.training.blog.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/newpost")
public class NewPostController {

    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private PostService postService;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView createPost(ModelMap modelMap) {
        BlogPost post = new BlogPost();
        modelMap.addAttribute("post", post);
        return new ModelAndView("newpost", "command", post);
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createPost(@ModelAttribute("post") BlogPost post, ModelMap modelMap) {
        postService.createPost(post);
        LOGGER.debug("New post added to database.");
        return "redirect:/index";
    }

}
