package hu.schonherz.training.controllers;

import hu.schonherz.training.dao.CommentDao;
import hu.schonherz.training.dao.PostDao;
import hu.schonherz.training.models.Comment;
import hu.schonherz.training.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Attila on 2016.07.28..
 */

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private PostDao postDao;

    @Autowired
    private CommentDao commentDao;

    @RequestMapping(method = RequestMethod.GET)
    public String listPosts(Model model){
        List<Post> posts = postDao.getAllPosts();
        model.addAttribute("posts",posts);
        return "blog/index";
    }

    @RequestMapping(path = "/post/{id}", method = RequestMethod.GET)
    public String viewPost(@PathVariable int id, Model model){
        Post post = postDao.getPostByID(id);
        model.addAttribute("post",post);
        return "blog/Post";
    }

    @RequestMapping(path = "/new", method = RequestMethod.POST)
    public String createPost(@ModelAttribute Post post, Model model){
        postDao.createPost(post);
        return "blog/index";
    }

    @RequestMapping(path = "/post/{id}/newcomment", method = RequestMethod.POST)
    public String createComment(@PathVariable int id, @ModelAttribute Comment comment, Model model){
        commentDao.createComment(id,comment);
        return "/blog/post/{id}";
    }

}
