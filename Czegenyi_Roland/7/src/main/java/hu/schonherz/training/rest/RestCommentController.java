package hu.schonherz.training.rest;

import hu.schonherz.training.dao.impl.BlogDaoImpl;
import hu.schonherz.training.dao.impl.CommentDaoImpl;
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
    private CommentDaoImpl commentDao;

    @RequestMapping(method = RequestMethod.GET, path = "/{blogId}")
    public ResponseEntity listComments(@PathVariable("blogId") int blogId) {
        List<Comment> comments = commentDao.getAllCommentByBlogId(blogId);
        return new ResponseEntity(comments, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/addComment")
    public ResponseEntity addBlog(@PathVariable("blogId") String id ,@RequestBody Comment comment) {
        int blogId = Integer.parseInt(id);
        comment.setBlogId(blogId);
        commentDao.addComment(comment);
        return new ResponseEntity(HttpStatus.OK);
    }
}
