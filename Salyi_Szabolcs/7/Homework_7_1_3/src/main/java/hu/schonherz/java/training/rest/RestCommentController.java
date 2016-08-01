package hu.schonherz.java.training.rest;

import hu.schonherz.java.training.dao.CommentDao;
import hu.schonherz.java.training.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Home on 2016. 08. 01..
 */

@RestController
@RequestMapping(value = "/rest/comment" , produces = "application/json")
public class RestCommentController {

    @Autowired
    private CommentDao commentDao;

    @RequestMapping(path = "/comments/{id}",method = RequestMethod.GET)
    public ResponseEntity getComments(@PathVariable int id){
        List<Comment> comments = commentDao.getAllCommnetById(id);
        return new ResponseEntity(comments, HttpStatus.OK) ;

    }
    @RequestMapping(path = "/addcomment", method = RequestMethod.POST)
    public ResponseEntity addComment(@RequestParam int id, @RequestBody Comment comment){
        comment.setBlogId(id);
        commentDao.addComment(comment.getBlogId(),comment.getComment());
        return new ResponseEntity(comment,HttpStatus.OK);
    }
}
