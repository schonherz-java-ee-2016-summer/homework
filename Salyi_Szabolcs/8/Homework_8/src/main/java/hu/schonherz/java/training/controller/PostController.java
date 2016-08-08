package hu.schonherz.java.training.controller;

import hu.schonherz.java.training.pojo.Comment;
import hu.schonherz.java.training.pojo.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import hu.schonherz.java.training.service.PostService;

/**
 * Created by Home on 2016. 08. 03..
 */

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping(path = "/new" , method = RequestMethod.GET)
    public String addNewPost(Model model){
        Post post = new Post();
        model.addAttribute("post" , post);
        return "newPost";
    }

    @RequestMapping(path = "/new" , method = RequestMethod.POST)
    public String addNewPost(@ModelAttribute("post") Post post, Model model){
        postService.addPost(post);
        return "redirect:/index";
    }

    @RequestMapping(path = "/{id}" , method = RequestMethod.GET)
    public String getPostById(@PathVariable Long id, Model model){

        Post post = postService.getPostById(id);
        model.addAttribute("post" , post);
        model.addAttribute("newcomment" , new Comment());

        return "post";
    }

    @RequestMapping(path = "/{id}" , method = RequestMethod.POST)
    public String addComment(
            @PathVariable long id, @ModelAttribute("newcomment") Comment comment, Model model){

        Post post = postService.getPostById(id);
        post.getComments().add(comment);
        postService.addPost(post);
        return ("redirect:/post/" + post.getId());
    }
}
