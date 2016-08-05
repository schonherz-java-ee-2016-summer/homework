package hu.schonherz.training.controller;

import hu.schonherz.training.dao.impl.CommentDaoImpl;
import hu.schonherz.training.pojo.Blog;
import hu.schonherz.training.dao.impl.BlogDaoImpl;
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
    private BlogDaoImpl blogDao;

    @Autowired
    private CommentDaoImpl commentDao;

    @RequestMapping(path = "/id={id}", method = RequestMethod.GET)
    public String blogDetails(@PathVariable String id, Model model) {

        int blogID = Integer.parseInt(id);

        Blog blog = blogDao.getBlogById(blogID);
        blog.setComments(commentDao.getAllCommentByBlogId(blogID));

        Comment comment = new Comment(blogID);

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
        blogDao.addBlog(blog);
        return "redirect:/index";
    }
}
