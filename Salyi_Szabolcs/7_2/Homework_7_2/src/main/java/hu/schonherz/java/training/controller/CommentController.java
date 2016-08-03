package hu.schonherz.java.training.controller;

import hu.schonherz.java.training.dao.CommentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Home on 2016. 08. 03..
 */

@Controller
@RequestMapping("/addcomment")
public class CommentController {

    @Autowired
    private CommentDao commentDao;

   /* @RequestMapping(method = RequestMethod.POST)
    public String addComment(@ModelAttribute Comment comment, Model model){



        return "redirect:/post/" + comment.getBlogId();
    }
*/
}
