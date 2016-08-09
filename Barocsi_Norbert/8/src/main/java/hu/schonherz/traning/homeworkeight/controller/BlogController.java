package hu.schonherz.traning.homeworkeight.controller;


import hu.schonherz.traning.homeworkeight.pojo.Comment;
import hu.schonherz.traning.homeworkeight.pojo.Post;
import hu.schonherz.traning.homeworkeight.service.CommentService;
import hu.schonherz.traning.homeworkeight.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Mindfield on 2016. 07. 31..
 */
@Controller
@RequestMapping("/post")
public class BlogController {

    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    @RequestMapping(method = RequestMethod.GET)
    public String listPosts(Model model){
        List<Post> posts =  postService.getAllPost();
        model.addAttribute("posts", posts);

        return "/postIndex";
    }

    @RequestMapping(path = "/details/{id}", method = RequestMethod.GET)
    public String blogDetails(@PathVariable Long id, Model model) {
        Post post = postService.getPostByIdentity(id);

        List<Comment> commentsOfPost = commentService.getAllCommentByBlogIdentity(id);
        post.setComments(commentsOfPost);

        model.addAttribute("post", post);
        model.addAttribute("comment", new Comment(id));

        return "/details";
    }

    @RequestMapping(path = "/create", method = RequestMethod.GET)
    public ModelAndView newPost(Model model){
        return new ModelAndView("/create", "command", new Post());
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public String newPost(@ModelAttribute Post post, Model model){
        post.setDate(LocalDateTime.now());
        postService.createPost(post);

        return "redirect:/post";
    }
}
