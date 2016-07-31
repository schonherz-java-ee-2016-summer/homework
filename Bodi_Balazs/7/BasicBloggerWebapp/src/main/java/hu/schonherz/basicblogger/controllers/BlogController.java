package hu.schonherz.basicblogger.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by bmbal on 2016. 07. 30..
 */
@Controller
@RequestMapping("/post/new")
public class BlogController {

    @RequestMapping(method = RequestMethod.GET)
    public String getNewBlogJsp(ModelMap model) {
        return "new";
    }
    @RequestMapping(method = RequestMethod.POST)
    public String addNewBlog(ModelMap model) {
        return "redirect:/post/*";
    }


}
