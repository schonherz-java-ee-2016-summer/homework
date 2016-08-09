package hu.schonherz.training.controller;


import hu.schonherz.training.service.CommentService;
import hu.schonherz.training.vo.CommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Roli on 2016. 07. 31..
 */
@Controller
@RequestMapping(path = "/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @RequestMapping(path = "/addComment", method = RequestMethod.POST)
    public String newComment(@RequestParam("id") String blogid,
                             @ModelAttribute("comment") CommentVo comment, Model model) {
        Long id = Long.parseLong(blogid);
        commentService.addCommnet(comment,id);
        return "redirect:/blog?id=" + blogid;

    }
}
