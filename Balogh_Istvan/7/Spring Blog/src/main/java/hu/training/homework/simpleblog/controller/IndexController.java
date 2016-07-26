package hu.training.homework.simpleblog.controller;

import hu.training.homework.simpleblog.dao.PostDAO;
import hu.training.homework.simpleblog.model.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private PostDAO dao;

    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String loadIndex(ModelMap modelMap) {
        LOGGER.debug("Loading all posts...");
        List<Post> posts = dao.getAllPosts();
        modelMap.addAttribute("posts", posts);
        LOGGER.debug("Added \"posts\" attribute on ModelMap");
        return "index";
    }

}
