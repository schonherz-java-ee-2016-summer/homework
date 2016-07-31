package hu.schonherz.basicblogger.rest;

import hu.schonherz.basicblogger.jdbcTemplates.CommentJDBCTemplate;
import hu.schonherz.basicblogger.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by bmbal on 2016. 07. 31..
 */
@RestController
public class CommentRestController {

    @Autowired
    private CommentJDBCTemplate commentJDBCTemplate;

    @RequestMapping(path = "/createcomment/{blog_id}", method = RequestMethod.POST)
    public ResponseEntity createComment(@RequestBody Comment comment, @PathVariable("blog_id") int blog_id){
        commentJDBCTemplate.createComment(comment);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(path = "/blog/{blog_id}", method = RequestMethod.GET)
    public ResponseEntity getComments(@PathVariable("blog_id") int blog_id, Model model){
        List<Comment> comments = commentJDBCTemplate.getAllComments(blog_id);
        return new ResponseEntity(comments, HttpStatus.OK);
    }
    
}
