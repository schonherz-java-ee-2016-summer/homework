package hu.schonherz.java.training.blog.controller;

import hu.schonherz.java.training.blog.dao.CommentDao;
import hu.schonherz.java.training.blog.dao.PostDao;
import hu.schonherz.java.training.blog.model.BlogComment;
import hu.schonherz.java.training.blog.model.BlogPost;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@Controller
@RequestMapping("/showpost*")
public class ShowPostController {

    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    private PostDao postDao;
    @Autowired
    private CommentDao commentDao;

    @RequestMapping(method = RequestMethod.GET)
    public String showPost(@RequestParam int id, ModelMap modelMap) {
        BlogPost selectedPost = postDao.getPostById(id);
        List<BlogComment> commentsOfPost = commentDao.getAllCommentByPostId(id);
        selectedPost.setComments(commentsOfPost);
        modelMap.addAttribute("post", selectedPost);
        modelMap.addAttribute("newcomment", new BlogComment(id));
        return "showpost";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addComment(@ModelAttribute("newcomment") BlogComment comment, ModelMap modelMap) {
        commentDao.createComment(comment.getPostId(), LocalDateTime.now(), comment.getContent());
        LOGGER.debug("New comment added to database.");
        return "redirect:/showpost?id=" + comment.getPostId();
    }

}
