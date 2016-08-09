package hu.schonherz.training.controllers;

import hu.schonherz.training.vo.PostVo;
import hu.schonherz.training.service.PostService;
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
    private PostService postService;

    @RequestMapping(method = RequestMethod.GET)
    public String listPosts(Model model){
        List<PostVo> postVos = postService.getAllPosts();
        LOG.info("We get all posts!");
        model.addAttribute("posts", postVos);
        return "index";
    }
}
