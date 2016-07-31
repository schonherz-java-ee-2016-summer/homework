package hu.schonherz.basicblogger.rest;

import hu.schonherz.basicblogger.jdbcTemplates.BlogJDBCTemplate;
import hu.schonherz.basicblogger.jdbcTemplates.CommentJDBCTemplate;
import hu.schonherz.basicblogger.pojo.Blog;
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
//@RestController
//@RequestMapping(path = "/rest", produces = "application/json")
public class CoreRestController {

    @Autowired
    private CommentJDBCTemplate commentJDBCTemplate;

    @Autowired
    private BlogJDBCTemplate blogJDBCTemplate;

    @RequestMapping(path = "/createblog", method = RequestMethod.POST)
    public ResponseEntity addPost(@RequestBody Blog blog) {
        blogJDBCTemplate.createBlog(blog);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(path = "/createcomment/{blog_id}", method = RequestMethod.POST)
    public ResponseEntity addComment(@RequestBody Comment comment, @PathVariable("blog_id") int blog_id){
        commentJDBCTemplate.createComment(comment);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(path = "/blogs", method = RequestMethod.GET)
    public ResponseEntity listPosts(Model model) {
        List<Blog> blogs = blogJDBCTemplate.getAllBlog();
        return new ResponseEntity(blogs, HttpStatus.OK);
    }

    @RequestMapping(path = "/blog/{blog_id}", method = RequestMethod.GET)
    public ResponseEntity getCommets(@PathVariable("blog_id") int blog_id, Model model){
        List<Comment> comments = commentJDBCTemplate.getAllComments(blog_id);
        return new ResponseEntity(comments, HttpStatus.OK);
    }
    
}
