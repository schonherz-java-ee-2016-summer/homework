package hu.schonherz.java.training.controller;

import hu.schonherz.java.training.dao.CommentDao;
import hu.schonherz.java.training.dao.PostDao;
import hu.schonherz.java.training.pojo.Comment;
import hu.schonherz.java.training.pojo.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Home on 2016. 08. 03..
 */

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostDao postDao;

    @Autowired
    private CommentDao commentDao;

    @RequestMapping(path = "/new" , method = RequestMethod.GET)
    public String addNewPost(Model model){
        Post post = new Post();
        model.addAttribute("post" , post);
        return "newPost";
    }

    @RequestMapping(path = "/new" , method = RequestMethod.POST)
    public String addNewPost(@ModelAttribute("post") Post post, Model model){
        postDao.addPost(post.getAuthor() , post.getTitle() , post.getContent());
        return "redirect:/index";
    }

    @RequestMapping(path = "/{id}" , method = RequestMethod.GET)
    public String getPostById(@PathVariable int id, Model model){

        Post post = postDao.getPostById(id);
        post.setComments(commentDao.getAllCommentById(id));
        model.addAttribute("post" , post);
        Comment comment = new Comment();
        comment.setBlogId(post.getId());
        model.addAttribute("newcomment" , comment);

        return "post";
    }

    @RequestMapping(path = "/{id}" , method = RequestMethod.POST)
    public String addComment(
            @PathVariable int id, @ModelAttribute("newcomment") Comment comment, Model model){

        commentDao.addComment( comment.getBlogId() ,comment.getContent());

        return ("redirect:/post/" + comment.getBlogId());
    }
}
