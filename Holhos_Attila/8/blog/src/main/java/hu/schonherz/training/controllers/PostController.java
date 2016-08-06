package hu.schonherz.training.controllers;

import hu.schonherz.training.models.Comment;
import hu.schonherz.training.models.Post;
import hu.schonherz.training.service.CommentService;
import hu.schonherz.training.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Attila on 2016.07.29..
 */

@Controller
@RequestMapping("/post")
public class PostController {

    private static final Logger LOG = LoggerFactory.getLogger(PostController.class);
    private SimpleDateFormat sf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public String viewPost(@PathVariable Long id, Model model){
        Post post = postService.getPostByID(id);
        List<Comment> comments = commentService.getAllCommentByPostId(post.getId());
        model.addAttribute("post", post);
        model.addAttribute("comments", comments);
        Comment comment = new Comment();
        comment.setPostID(post.getId());
        model.addAttribute("comment", comment);
        LOG.info("View a post! Id=" + post.getId());
        return "viewPost";
    }

    @RequestMapping(path = "/new", method = RequestMethod.GET)
    public String createPost(Model model){
        Post post = new Post();
        model.addAttribute("post", post);
        LOG.info("Try create post!");
        return "newPost";
    }

    @RequestMapping(path = "/new", method = RequestMethod.POST)
    public String createPost(@ModelAttribute("post") Post post, Model model){
        post.setPostDate(sf.format(new Date()));
        postService.createPost(post);
        LOG.info("A new post was added!");
        return "redirect:/index";
    }
}
