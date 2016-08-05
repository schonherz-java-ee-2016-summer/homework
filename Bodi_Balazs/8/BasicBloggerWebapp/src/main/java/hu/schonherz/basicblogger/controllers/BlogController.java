package hu.schonherz.basicblogger.controllers;

import hu.schonherz.basicblogger.pojo.Blog;
import hu.schonherz.basicblogger.user.User;
import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * Created by bmbal on 2016. 07. 30..
 */
@Controller
@RequestMapping("/post/new")
public class BlogController {

    private static final Logger LOG = LoggerFactory.getLogger(BlogController.class);

    @Autowired
    private User user;

    @RequestMapping(method = RequestMethod.GET)
    public String showBlogPage(Model model) {
        LOG.info("GET request arrived to BlogController");
        return "new";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createBlog(@ModelAttribute Blog blog, Model model) {
        LOG.info("POST request arrived to BlogController");
        try {
            blog.setTitle(StringEscapeUtils.escapeHtml4(blog.getTitle()));
            blog.setContent(StringEscapeUtils.escapeHtml4(blog.getTitle()));
            blog.setTitle(URLDecoder.decode(blog.getTitle(), "UTF-8"));
            blog.setContent(URLDecoder.decode(blog.getContent(), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        blog.setAuthor(user.getName());
        return "redirect:/index";
    }

}
