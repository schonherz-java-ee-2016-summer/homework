package hu.schonherz.java.training.controllers;

import hu.schonherz.java.training.dao.PostDao;
import hu.schonherz.java.training.pojo.Post;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Home on 2016. 07. 29..
 */

@Controller
@RequestMapping("/")
public class IndexController {

   /* public String welcome(ModelMap model){

        model.addAttribute("message", "Szabi Bolgja");
        return "hello";
    }*/

    @Autowired
    private PostDao postDao;

    @RequestMapping(method = RequestMethod.GET)
    public String listPosts(Model model){
        List<Post> posts = postDao.getAllPost();

            model.addAttribute("posts", posts);
            return "welcome";
        }
}

