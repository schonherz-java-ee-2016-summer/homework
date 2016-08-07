package hu.schonherz.training.bloggyak.controllers;

import hu.schonherz.training.bloggyak.data.entities.PostEntity;
import hu.schonherz.training.bloggyak.service.PostService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.util.List;

/**
 * Created by Lenovo on 2016.08.07..
 */

@Controller
@RequestMapping("/index")
public class IndexController {
    @Autowired
    private PostService postService;

    @RequestMapping(method = RequestMethod.GET)
    public String listPosts(Model model){
        List<PostEntity> posts = postService.getAllPosts();
        model.addAttribute("posts", posts);
        return "index";
    }
}
