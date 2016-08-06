package hu.nutty.kepzes.blogapp.rest;

import hu.nutty.kepzes.blogapp.beans.BlogPost;
import hu.nutty.kepzes.blogapp.beans.Comment;
import hu.nutty.kepzes.blogapp.dao.BlogPostDAO;
import hu.nutty.kepzes.blogapp.dao.CommentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Nutty on 2016.07.26..
 */

@RestController()
@RequestMapping(path = "/api/comments", produces = "application/json")
public class RestCommentController {
    @Autowired
    private CommentDAO commentDAO;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity listComments(Model model) {
        List<Comment> comments = commentDAO.getAllComments();
        return new ResponseEntity(comments, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addComment(@RequestBody Comment comment) {
        commentDAO.addComment(comment);
        return new ResponseEntity(HttpStatus.OK);
    }
}

