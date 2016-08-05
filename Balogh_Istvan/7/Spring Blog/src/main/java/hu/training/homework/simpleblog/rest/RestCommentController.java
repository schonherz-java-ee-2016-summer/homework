package hu.training.homework.simpleblog.rest;

import hu.training.homework.simpleblog.dao.CommentDAO;
import hu.training.homework.simpleblog.model.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/comments", produces = "application/json")
public class RestCommentController {

    @Autowired
    private CommentDAO commentDAO;

    @RequestMapping(path = "/getcomments", method = RequestMethod.GET)
    public ResponseEntity loadCommentsOfPost(@RequestParam String id) {
        List<Comment> comments = commentDAO.getCommentsOfPost(id);
        return new ResponseEntity(comments, HttpStatus.OK);
    }

    @RequestMapping(path = "/addcomment", method = RequestMethod.POST)
    public ResponseEntity addComment(@RequestParam String id, @RequestBody Comment comment) {
        comment.setPostID(id);
        commentDAO.addComment(comment);
        return new ResponseEntity(HttpStatus.OK);
    }
}
