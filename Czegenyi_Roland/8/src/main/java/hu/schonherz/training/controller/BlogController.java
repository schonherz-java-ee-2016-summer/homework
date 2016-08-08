package hu.schonherz.training.controller;

import hu.schonherz.training.service.BlogService;
import hu.schonherz.training.vo.BlogVo;
import hu.schonherz.training.vo.CommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @RequestMapping(method = RequestMethod.GET)
    public String blogDetails(@RequestParam String id, Model model) {

        Long blogID = Long.parseLong(id);
        BlogVo blog = blogService.getBlogById(blogID);

        CommentVo comment = new CommentVo();

        model.addAttribute("comment", comment);
        model.addAttribute("blog", blog);
        return "post";
    }

    @RequestMapping(path = "/addpost", method = RequestMethod.GET)
    public ModelAndView newBlog() {
        return new ModelAndView("addpost", "command", new BlogVo());
    }

    @RequestMapping(path = "/addpost", method = RequestMethod.POST)
    public String newBlog(@ModelAttribute("blog") BlogVo blog, Model model) {
        blogService.createBlog(blog);
        return "redirect:/index";
    }
}
