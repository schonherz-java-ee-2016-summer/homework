package hu.nutty.kepzes.blogapp.controllers;

import hu.nutty.kepzes.blogapp.dto.BlogPostDTO;
import hu.nutty.kepzes.blogapp.dto.BloggerDTO;
import hu.nutty.kepzes.blogapp.dao.BlogPostDAO;
import hu.nutty.kepzes.blogapp.dao.BloggerDAO;
import hu.nutty.kepzes.blogapp.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

import static hu.nutty.kepzes.blogapp.utils.Constants.*;


@Controller
public class IndexController {
    @Autowired
    private BlogPostDAO blogPostDAO;
    @Autowired
    private BloggerDAO bloggerDAO;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String redirectRoot(ModelMap model) {
        return "redirect:index";
    }

    @RequestMapping(value = "/" + Constants.INDEX_KEY, method = RequestMethod.GET)
    public String displayIndex(ModelMap model) {

        List<BlogPostDTO> blogPosts = null;
        try {
            blogPosts = blogPostDAO.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        model.addAttribute(POSTS, blogPosts);

        return "index";
    }

    @RequestMapping(value = "/" + Constants.INDEX_KEY, method = RequestMethod.POST)
    public String createNewPost(@ModelAttribute("blogger") BloggerDTO blogger, @ModelAttribute("blogPost") BlogPostDTO blogPost) {
        try {
            bloggerDAO.save(blogger);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //blogger = bloggerDAO.getBloggerByNickName(blogger.getNickName());
        blogPost.setAuthor(blogger);
        try {
            blogPostDAO.save(blogPost);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:index";
    }

}
