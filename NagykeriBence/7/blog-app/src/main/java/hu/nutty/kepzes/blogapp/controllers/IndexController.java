package hu.nutty.kepzes.blogapp.controllers;

import hu.nutty.kepzes.blogapp.beans.BlogPost;
import hu.nutty.kepzes.blogapp.beans.Blogger;
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

        List<BlogPost> blogPosts = blogPostDAO.getAllBlogPosts();
        model.addAttribute(POSTS, blogPosts);

        return "index";
    }

    @RequestMapping(value = "/" + Constants.INDEX_KEY, method = RequestMethod.POST)
    public String createNewPost(@ModelAttribute("blogger") Blogger blogger, @ModelAttribute("blogPost") BlogPost blogPost) {
        blogger.setBloggerID(bloggerDAO.addBloggerAndReturnId(blogger));
        blogger = bloggerDAO.getBloggerByNickName(blogger.getNickName());
        blogPost.setAuthor(blogger);
        blogPostDAO.addBlogPost(blogPost);

        return "redirect:index";
    }

}
