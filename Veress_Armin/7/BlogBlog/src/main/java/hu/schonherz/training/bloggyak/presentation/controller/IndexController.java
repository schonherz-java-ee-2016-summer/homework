package hu.schonherz.training.bloggyak.presentation.controller;

import hu.schonherz.training.bloggyak.data.pojo.Post;
import hu.schonherz.training.bloggyak.data.pojo.PostBean;
import hu.schonherz.training.bloggyak.data.dao.PostDAO;
import hu.schonherz.training.bloggyak.data.dao.impl.PostDAOImpl;
import java.util.Collections;
import hu.schonherz.training.bloggyak.utils.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Lenovo on 2016.07.31..
 */

@Controller
public class IndexController {

    @Autowired
    private PostDAO blogPostDAO;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String redirectRoot(ModelMap model) {
        return "redirect:index";
    }

    @RequestMapping(value = "/" + Parameters.INDEX_KEY, method = RequestMethod.GET)
    public String displayPosts(ModelMap model) {

        List<Post> blogPosts = blogPostDAO.findAll();
        model.addAttribute(Parameters.POST_POSTS, blogPosts);

        return "index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String addNewPost(ModelMap model, HttpServletRequest req) {

        List<Post> blogPosts = blogPostDAO.findAll();
        Post post = new Post();
        post.setAuthor(req.getParameter(Parameters.POST_AUTHOR));
        post.setTitle(req.getParameter(Parameters.POST_TITLE));
        post.setContent(req.getParameter(Parameters.POST_CONTENT));
        blogPostDAO.save(post);

        return "redirect:index";
    }
}