package hu.schonherz.traning.homeworkseven.rest;

import hu.schonherz.traning.homeworkseven.jdbctemplate.CommentJDBCTemplate;
import hu.schonherz.traning.homeworkseven.pojo.Comment;
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
    public CommentJDBCTemplate commentJDBCTemplate;

    @RequestMapping(path = "/getcomments/{id}", method = RequestMethod.GET)
    public ResponseEntity loadCommentsOfPost(@PathVariable("id") int postId) {
        List<Comment> comments = commentJDBCTemplate.getAllCommentByPostId(postId);
        return new ResponseEntity(comments, HttpStatus.OK);
    }

    @RequestMapping(path = "/addcomment", method = RequestMethod.POST)
    public ResponseEntity addComment(@RequestParam int postId, @RequestBody Comment comment) {
        comment.setBlogIdentity(postId);
        commentJDBCTemplate.createComment(comment.getBlogIdentity(), comment.getContent());
        return new ResponseEntity(HttpStatus.OK);
    }
}
