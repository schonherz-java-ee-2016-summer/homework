package hu.schonherz.java.training.controller;

import hu.schonherz.java.training.dao.PostDao;
import hu.schonherz.java.training.pojo.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Home on 2016. 08. 03..
 */

@Controller
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private PostDao postDao;

    @RequestMapping( method = RequestMethod.GET )
    public String getAllPosts(Model model){
        List<Post> posts = postDao.getAllPost();
        model.addAttribute("posts" , posts);
        return "index";
    }
}
