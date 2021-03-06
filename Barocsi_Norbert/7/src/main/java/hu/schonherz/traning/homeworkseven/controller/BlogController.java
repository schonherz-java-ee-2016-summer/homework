package hu.schonherz.traning.homeworkseven.controller;

import hu.schonherz.traning.homeworkseven.jdbctemplate.CommentJDBCTemplate;
import hu.schonherz.traning.homeworkseven.jdbctemplate.PostJDBCTemplate;
import hu.schonherz.traning.homeworkseven.pojo.Comment;
import hu.schonherz.traning.homeworkseven.pojo.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by Mindfield on 2016. 07. 31..
 */
@Controller
@RequestMapping("/post")
public class BlogController {

    @Autowired
    private PostJDBCTemplate postJDBCTemplate;
    @Autowired
    private CommentJDBCTemplate commentJDBCTemplate;

    @RequestMapping(method = RequestMethod.GET)
    public String listPosts(Model model){
        List<Post> posts =  postJDBCTemplate.getAllPost();
        model.addAttribute("posts", posts);

        return "/postIndex";
    }

    @RequestMapping(path = "/details/{id}", method = RequestMethod.GET)
    public String blogDetails(@PathVariable int id, Model model) {
        Post post = postJDBCTemplate.getPostById(id);

        List<Comment> commentsOfPost = commentJDBCTemplate.getAllCommentByPostId(id);
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
        postJDBCTemplate.createPost(post.getCreator(), post.getTitle(), post.getText());

        return "redirect:/post";
    }
}
