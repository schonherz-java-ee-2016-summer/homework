package hu.schonherz.traning.homeworkseven.dao.controller;

import hu.schonherz.traning.homeworkseven.dao.jdbctemplate.CommentJDBCTemplate;
import hu.schonherz.traning.homeworkseven.dao.pojo.Comment;
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
@RequestMapping("/comment")
public class CommentController  {

    @Autowired
    private CommentJDBCTemplate commentJDBCTemplate;

    @RequestMapping(value = "/details", method = RequestMethod.GET)
    public String displayLogin(Model model) {
        model.addAttribute("comment", new Comment());
        return "/details";
    }

    @RequestMapping(path = "/details/{id}", method = RequestMethod.GET)
    public String listComments(@PathVariable int id, Model model){
        List<Comment> comments = commentJDBCTemplate.getAllCommentByPostId(id);
        model.addAttribute("comments", comments);

        return "/details";
    }

    @RequestMapping(path = "/details", method = RequestMethod.GET)
    public ModelAndView newComment(Model model){
        return new ModelAndView("/details", "command", new Comment());
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String newComment(@ModelAttribute Comment comment, Model model){
        commentJDBCTemplate.createComment(comment.getBlog_identity(), comment.getContent());

        return "redirect:/post/details/" + comment.getBlog_identity();
    }
}
