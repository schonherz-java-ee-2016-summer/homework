package hu.schonherz.traning.homeworkeight.controller;


import hu.schonherz.traning.homeworkeight.pojo.Comment;
import hu.schonherz.traning.homeworkeight.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.time.LocalDateTime;

/**
 * Created by Mindfield on 2016. 07. 31..
 */
@Controller
@RequestMapping("/")
public class CommentController  {

    @Autowired
    private CommentService commentService;

    @RequestMapping(path = "post/details/add", method = RequestMethod.POST)
    public String newComment(@ModelAttribute Comment comment, Model model){
        comment.setDate(LocalDateTime.now());
        commentService.createComment(comment);

        return "redirect:/post/details/" + comment.getBlogIdentity();
    }
}
