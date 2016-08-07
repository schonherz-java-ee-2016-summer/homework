package hu.schonherz.training.bloggyak.controllers;

import hu.schonherz.training.bloggyak.data.entities.CommentEntity;
import hu.schonherz.training.bloggyak.service.CommentService;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by Lenovo on 2016.08.07..
 */

@Controller
@RequestMapping("/comment")
public class CommentController {

    private SimpleDateFormat sf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

    @Autowired
    private CommentService commentService;

    @RequestMapping(path = "/add", method = RequestMethod.GET)
    public String addComment(Model model){
        CommentEntity comment = new CommentEntity();
        model.addAttribute("comment", comment);
        return "newcomment";
    }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public String addComment(@ModelAttribute("comment") CommentEntity comment, Model model){
        comment.setDate(LocalDateTime.now());
        commentService.newComment(comment);
        return ("redirect:/post/" + comment.getId());
    }
}
