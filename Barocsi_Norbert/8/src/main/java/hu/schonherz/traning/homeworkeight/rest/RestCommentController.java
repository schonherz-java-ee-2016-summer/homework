package hu.schonherz.traning.homeworkeight.rest;

import hu.schonherz.traning.homeworkeight.pojo.Comment;
import hu.schonherz.traning.homeworkeight.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Mindfield on 2016. 08. 01..
 */
@RestController
@RequestMapping(value = "/rest/comments", produces = "application/json")
public class RestCommentController {

    @Autowired
    public CommentService commentService;

    @RequestMapping(path = "/getcomments/{id}", method = RequestMethod.GET)
    public ResponseEntity loadCommentsOfPost(@PathVariable("id") Long postId) {
        List<Comment> comments = commentService.getAllCommentByBlogIdentity(postId);
        return new ResponseEntity(comments, HttpStatus.OK);
    }

    @RequestMapping(path = "/addcomment", method = RequestMethod.POST)
    public ResponseEntity addComment(@RequestParam Long postId, @RequestBody Comment comment) {
        comment.setBlogIdentity(postId);
        commentService.createComment(comment);
        return new ResponseEntity(HttpStatus.OK);
    }
}
