package hu.training.homework.springblog.controller;

import hu.training.homework.springblog.repository.PostDAO;
import hu.training.homework.springblog.model.Post;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private PostDAO dao;

    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String loadIndex(ModelMap modelMap) {
        LOGGER.debug("Loading all posts...");
        List<Post> posts = dao.getAllPosts();
        Collections.reverse(posts);
        modelMap.addAttribute("posts", posts);
        LOGGER.debug("Added \"posts\" attribute on ModelMap");
        return "index";
    }

}
