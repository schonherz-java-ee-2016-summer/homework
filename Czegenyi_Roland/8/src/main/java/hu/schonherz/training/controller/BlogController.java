package hu.schonherz.training.controller;

import hu.schonherz.training.dao.BlogDao;
import hu.schonherz.training.dao.CommentDao;
import hu.schonherz.training.pojo.Blog;
import hu.schonherz.training.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/blog")
public class BlogController {

    @Autowired
    private BlogDao blogDao;

    @Autowired
    private CommentDao commentDao;

    @RequestMapping(path = "/id={id}", method = RequestMethod.GET)
    public String blogDetails(@PathVariable String id, Model model) {

        Long blogID = Long.parseLong(id);

        Blog blog = blogDao.findById(blogID);
        blog.setComments(commentDao.findAll(blogID));

        Comment comment = new Comment();

        model.addAttribute("comment", comment);
        model.addAttribute("blog", blog);
        return "post";
    }

    @RequestMapping(path = "/addpost", method = RequestMethod.GET)
    public ModelAndView newBlog() {
        return new ModelAndView("addpost", "command", new Blog());
    }

    @RequestMapping(path = "/addpost", method = RequestMethod.POST)
    public String newBlog(@ModelAttribute("blog") Blog blog, Model model) {
        blogDao.save(blog);
        return "redirect:/index";
    }
}
