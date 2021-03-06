package hu.schonherz.training.controllers;

import hu.schonherz.training.vo.CommentVo;
import hu.schonherz.training.service.CommentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Attila on 2016.07.29..
 */

@Controller
@RequestMapping("/comment")
public class CommentController {

    private static final Logger LOG = LoggerFactory.getLogger(CommentController.class);
    private SimpleDateFormat sf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

    @Autowired
    private CommentService commentService;

    @RequestMapping(path = "/new", method = RequestMethod.POST)
    public String addcomment(@ModelAttribute("comment") CommentVo commentVo, Model model){
        LOG.info("A comment was added to post " + commentVo.getPostid() + "!");
        commentVo.setCommentDate(sf.format(new Date()));
        commentService.createComment(commentVo);
        LOG.info("A comment was added to post " + commentVo.getPostid() + "!");
        return ("redirect:/post/" + commentVo.getPostid());
    }
}
