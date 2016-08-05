package hu.schonherz.basicblogger.controllers;

import hu.schonherz.basicblogger.jdbcTemplates.BlogJDBCTemplate;
import hu.schonherz.basicblogger.pojo.Blog;
import hu.schonherz.basicblogger.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by bmbal on 2016. 07. 30..
 */
@Controller
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private User user;

    @Autowired
    private BlogJDBCTemplate blogJDBCTemplate;

    @RequestMapping(method = RequestMethod.GET)
    public String listAllBlogs(Model model) {
        List<Blog> blogs = blogJDBCTemplate.getAllBlog();
        model.addAttribute("blogs", blogs);
        return "index";
    }
}