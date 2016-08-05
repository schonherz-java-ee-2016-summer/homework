package hu.schonherz.training.controllers;

import hu.schonherz.training.dao.PostDao;
import hu.schonherz.training.models.Post;
import hu.schonherz.training.servlets.BlogPostServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Attila on 2016.07.29..
 */

@Controller
@RequestMapping("/index")
public class IndexController {

    private static final Logger LOG = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private PostDao postDao;

    @RequestMapping(method = RequestMethod.GET)
    public String listPosts(Model model){
        List<Post> posts = postDao.getAllPosts();
        LOG.info("We get all posts!");
        model.addAttribute("posts", posts);
        return "index";
    }
}
