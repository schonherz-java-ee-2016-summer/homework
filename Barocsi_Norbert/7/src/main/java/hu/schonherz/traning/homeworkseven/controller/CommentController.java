package hu.schonherz.traning.homeworkseven.controller;

import hu.schonherz.traning.homeworkseven.jdbctemplate.CommentJDBCTemplate;
import hu.schonherz.traning.homeworkseven.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Mindfield on 2016. 07. 31..
 */
@Controller
@RequestMapping("/")
public class CommentController  {

    @Autowired
    private CommentJDBCTemplate commentJDBCTemplate;

    @RequestMapping(path = "post/details/add", method = RequestMethod.POST)
    public String newComment(@ModelAttribute Comment comment, Model model){

        commentJDBCTemplate.createComment(comment.getBlogIdentity(), comment.getContent());

        return "redirect:/post/details/" + comment.getBlogIdentity();
    }
}
