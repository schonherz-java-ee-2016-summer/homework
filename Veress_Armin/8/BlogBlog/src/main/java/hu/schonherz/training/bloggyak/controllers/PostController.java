package hu.schonherz.training.bloggyak.controllers;

import hu.schonherz.training.bloggyak.data.entities.CommentEntity;
import hu.schonherz.training.bloggyak.service.CommentService;
import hu.schonherz.training.bloggyak.data.entities.PostEntity;
import hu.schonherz.training.bloggyak.service.PostService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * Created by Lenovo on 2016.08.07..
 */

@Controller
@RequestMapping("/post")
public class PostController {

    private SimpleDateFormat sf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public String viewPost(@PathVariable Long id, Model model){
        PostEntity post = postService.getPostById(id);
        List<CommentEntity> comments = commentService.getAllPostCommentsById(post.getId());
        model.addAttribute("post", post);
        model.addAttribute("comments", comments);
        CommentEntity comment = new CommentEntity();
        comment.setId(post.getId());
        model.addAttribute("comment", comment);
        return "Post";
    }

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String addPost(Model model){
        PostEntity post = new PostEntity();
        model.addAttribute("post", post);
        return "newPost";
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String addPost(@ModelAttribute("post") PostEntity post, Model model){
        post.setDate(LocalDateTime.now());
        postService.newPost(post);
        return "redirect:/index";
    }
}
