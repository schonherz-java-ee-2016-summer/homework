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
 * Created by Attila on 2016.07.29..
 */

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostDao postDao;

    @Autowired
    private CommentDao commentDao;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String viewPost(@PathVariable int id, Model model){
        Post post = postDao.getPostByID(id);
        List<Comment> comments = commentDao.getAllCommentByPostId(post.getPostID());
        model.addAttribute("post", post);
        model.addAttribute("comments", comments);
        Comment comment = new Comment();
        comment.setPostID(post.getPostID());
        model.addAttribute("comment", comment);
        return "viewPost";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String createPost(Model model){
        Post post = new Post();
        model.addAttribute("post", post);
        return "newPost";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String createPost(@ModelAttribute("post") Post post, Model model){
        postDao.createPost(post);
        return "redirect:/index";
    }
}
