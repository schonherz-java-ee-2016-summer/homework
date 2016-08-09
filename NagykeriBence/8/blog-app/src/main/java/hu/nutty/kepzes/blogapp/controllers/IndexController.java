package hu.nutty.kepzes.blogapp.controllers;

import hu.nutty.kepzes.blogapp.dto.BlogPostDTO;
import hu.nutty.kepzes.blogapp.dto.BloggerDTO;
import hu.nutty.kepzes.blogapp.dao.BlogPostDAO;
import hu.nutty.kepzes.blogapp.dao.BloggerDAO;
import hu.nutty.kepzes.blogapp.services.BlogPostService;
import hu.nutty.kepzes.blogapp.services.BloggerService;
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
    private BlogPostService blogPostService;
    @Autowired
    private BloggerService bloggerService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String redirectRoot(ModelMap model) {
        return "redirect:index";
    }

    @RequestMapping(value = "/" + Constants.INDEX_KEY, method = RequestMethod.GET)
    public String displayIndex(ModelMap model) {
        List<BlogPostDTO> blogPosts = blogPostService.getAllBlogPosts();
        model.addAttribute(POSTS, blogPosts);
        return "index";
    }

    @RequestMapping(value = "/" + Constants.INDEX_KEY, method = RequestMethod.POST)
    public String createNewPost(@ModelAttribute("blogger") BloggerDTO blogger, @ModelAttribute("blogPost") BlogPostDTO blogPost) {
      // blogger.setBloggerID(bloggerService.createBlogger(blogger).intValue());
        blogPost.setAuthor(blogger);

        blogPost.setPostID(blogPostService.createBlogPost(blogPost).intValue());


        return "redirect:index";
    }

}
