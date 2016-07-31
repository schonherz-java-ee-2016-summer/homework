package hu.schonherz.basicblogger.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by bmbal on 2016. 07. 30..
 */
@Controller
@RequestMapping("post/**")
public class CommentController {
    @RequestMapping(method = RequestMethod.GET)
    public String getCommentsPage(ModelMap model) {
        return "post";
    }
    @RequestMapping(method = RequestMethod.POST)
    public String addNewComment(ModelMap model) {
        return "post";
    }
}
