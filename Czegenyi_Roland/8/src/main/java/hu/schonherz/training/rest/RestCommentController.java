package hu.schonherz.training.rest;

import hu.schonherz.training.dao.CommentDao;
import hu.schonherz.training.pojo.Blog;
import hu.schonherz.training.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Roli on 2016. 07. 31..
 */

@RestController
@RequestMapping(value = "/api/blogs/comments", produces = "application/json")
public class RestCommentController {
    @Autowired
    private CommentDao commentDao;

    @RequestMapping(method = RequestMethod.GET, path = "/{blogId}")
    public ResponseEntity listComments(@PathVariable("blogId") Long blogId) {
        List<Comment> comments = commentDao.findAll(blogId);
        return new ResponseEntity(comments, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/addComment")
    public ResponseEntity addBlog(@PathVariable("blogId") String id ,@RequestBody Comment comment) {
        Long blogId = Long.parseLong(id);
        comment.setId(blogId);
        commentDao.save(comment);
        return new ResponseEntity(HttpStatus.OK);
    }
}
