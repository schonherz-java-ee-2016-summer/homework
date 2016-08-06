package hu.schonherz.basicblogger.controllers;

import hu.schonherz.basicblogger.jdbcTemplates.BlogJDBCTemplate;
import hu.schonherz.basicblogger.jdbcTemplates.CommentJDBCTemplate;
import hu.schonherz.basicblogger.pojo.Blog;
import hu.schonherz.basicblogger.pojo.Comment;
import hu.schonherz.basicblogger.user.User;
import org.apache.commons.lang3.StringEscapeUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

/**
 * Created by bmbal on 2016. 07. 30..
 */
@Controller
@RequestMapping("post/{id}")
public class CommentController {

    private static final Logger LOG = LoggerFactory.getLogger(CommentController.class);

    @Autowired
    private User user;

    @Autowired
    private CommentJDBCTemplate commentJDBCTemplate;

    @Autowired
    private BlogJDBCTemplate blogJDBCTemplate;

    @RequestMapping(method = RequestMethod.GET)
    public String getAllComment(@PathVariable int id , Model model) {
        LOG.info("GET request arrived to CommentController");
        List<Comment> comments = commentJDBCTemplate.getAllComments(id);
        Blog blog = blogJDBCTemplate.getBlogById(id);
        model.addAttribute("comments", comments);
        model.addAttribute("blog", blog);
        return "post";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String addNewComment(@ModelAttribute("comment") Comment comment, ModelMap model) {
        LOG.info("POST request arrived to CommentController");
        try {
            comment.setContent(StringEscapeUtils.escapeHtml4(comment.getContent()));
            comment.setContent(URLDecoder.decode(comment.getContent(), "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        comment.setAuthor(user.getName());
        commentJDBCTemplate.createComment(comment);
        return "redirect:/post/" + comment.getBlogId();
    }
}
