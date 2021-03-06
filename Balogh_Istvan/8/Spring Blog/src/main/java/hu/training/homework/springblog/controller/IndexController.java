package hu.training.homework.springblog.controller;

import hu.training.homework.springblog.model.Post;
import hu.training.homework.springblog.service.PostService;
import hu.training.homework.springblog.util.Parameters;
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
    private PostService postService;

    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @RequestMapping(method = RequestMethod.GET)
    public String loadIndex(ModelMap modelMap) {
        LOGGER.debug("Loading all posts...");
        List<Post> posts = postService.getAllPosts();
        Collections.reverse(posts);
        modelMap.addAttribute(Parameters.POSTS_ATTRIBUTE_NAME, posts);
        LOGGER.debug("Added " + Parameters.POSTS_ATTRIBUTE_NAME + " attribute on ModelMap");
        return Parameters.INDEX_PAGE;
    }

}
