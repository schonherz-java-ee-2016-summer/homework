package hu.schonherz.java.training.controller;

import hu.schonherz.java.training.pojo.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import hu.schonherz.java.training.service.PostService;

import java.util.List;

/**
 * Created by Home on 2016. 08. 03..
 */

@Controller
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private PostService postService;

    @RequestMapping( method = RequestMethod.GET )
    public String getAllPosts(Model model){
        List<Post> posts = postService.getAllPost();
        model.addAttribute("posts" , posts);
        return "index";
    }
}
