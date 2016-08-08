package hu.schonherz.training.controllers;

import hu.schonherz.training.vo.CommentVo;
import hu.schonherz.training.vo.PostVo;
import hu.schonherz.training.service.CommentService;
import hu.schonherz.training.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Attila on 2016.07.29..
 */

@Controller
@RequestMapping("/post")
public class PostController {

    private static final Logger LOG = LoggerFactory.getLogger(PostController.class);
    private SimpleDateFormat sf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");

    @Autowired
    private PostService postService;

    @Autowired
    private CommentService commentService;

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public String viewPost(@PathVariable Long id, Model model){
        PostVo postVo = postService.getPostByID(id);
        List<CommentVo> commentVos = commentService.getAllCommentByPostId(postVo.getId());
        model.addAttribute("post", postVo);
        model.addAttribute("comments", commentVos);
        CommentVo commentVo = new CommentVo();
        commentVo.setPostid(postVo.getId());
        model.addAttribute("comment", commentVo);
        LOG.info("View a post! Id=" + postVo.getId());
        return "viewPost";
    }

    @RequestMapping(path = "/new", method = RequestMethod.GET)
    public String createPost(Model model){
        PostVo postVo = new PostVo();
        model.addAttribute("post", postVo);
        LOG.info("Try create post!");
        return "newPost";
    }

    @RequestMapping(path = "/new", method = RequestMethod.POST)
    public String createPost(@ModelAttribute("post") PostVo postVo, Model model){
        postVo.setPostDate(sf.format(new Date()));
        postService.createPost(postVo);
        LOG.info("A new post was added!");
        return "redirect:/index";
    }
}
