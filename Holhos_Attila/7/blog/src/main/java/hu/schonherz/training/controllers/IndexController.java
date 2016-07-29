package hu.schonherz.training.controllers;

import hu.schonherz.training.dao.PostDao;
import hu.schonherz.training.models.Post;
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

    @Autowired
    private PostDao postDao;

    @RequestMapping(method = RequestMethod.GET)
    public String listPosts(Model model){
        List<Post> posts = postDao.getAllPosts();
        model.addAttribute("posts",posts);
        return "index";
    }
}
