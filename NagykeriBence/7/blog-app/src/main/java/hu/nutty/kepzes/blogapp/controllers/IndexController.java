package hu.nutty.kepzes.blogapp.controllers;

import hu.nutty.kepzes.blogapp.beans.BlogPost;
import hu.nutty.kepzes.blogapp.beans.BlogPostsBean;
import hu.nutty.kepzes.blogapp.beans.Blogger;
import hu.nutty.kepzes.blogapp.dao.BlogPostDAO;
import hu.nutty.kepzes.blogapp.dao.BloggerDAO;
import hu.nutty.kepzes.blogapp.dao.implementations.BlogPostDAOImpl;
import hu.nutty.kepzes.blogapp.utils.Constants;
import hu.nutty.kepzes.blogapp.utils.ParserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
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
    public String createNewPost(ModelMap model, HttpServletRequest req) {

        List<BlogPost> blogPosts = blogPostDAO.getAllBlogPosts();
        Blogger author = ParserUtils.parseBodyAsBlogger(req);
        bloggerDAO.addBlogger(author);
        author = bloggerDAO.getBloggerByNickName(author.getNickName()); //to get the id
        BlogPost post = ParserUtils.parseBodyAsPost(req);
        post.setAuthor(author);
        blogPostDAO.addBlogPost(post);

        return "redirect:index";
    }

}
