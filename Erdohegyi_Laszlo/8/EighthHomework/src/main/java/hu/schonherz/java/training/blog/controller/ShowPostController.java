package hu.schonherz.java.training.blog.controller;

import hu.schonherz.java.training.blog.dao.CommentDao;
import hu.schonherz.java.training.blog.dao.PostDao;
import hu.schonherz.java.training.blog.entity.BlogComment;
import hu.schonherz.java.training.blog.entity.BlogPost;
import hu.schonherz.java.training.blog.service.CommentService;
import hu.schonherz.java.training.blog.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@Controller
@RequestMapping("/showpost/{id}")
public class ShowPostController {

    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private PostService postService;
    @Autowired
    private CommentService commentService;

    @RequestMapping(method = RequestMethod.GET)
    public String showPost(@PathVariable Long id, ModelMap modelMap) {
        BlogPost selectedPost = postService.getPostById(id);
        List<BlogComment> commentsOfPost = commentService.getAllCommentByPostId(id);
        selectedPost.setComments(commentsOfPost);
        modelMap.addAttribute("post", selectedPost);
        modelMap.addAttribute("newcomment", new BlogComment());
        return "showpost";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addComment(@PathVariable int id, @ModelAttribute("newcomment") BlogComment comment, ModelMap modelMap) {
        commentService.createComment(comment);
        LOGGER.debug("New comment added to database.");
        return "redirect:/showpost/{id}";
    }

}
