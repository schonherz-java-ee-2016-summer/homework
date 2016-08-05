package hu.schonherz.java.training.blog.rest;

import hu.schonherz.java.training.blog.jdbctemplate.PostJDBCTemplate;
import hu.schonherz.java.training.blog.model.BlogPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/posts", produces = "application/json")
public class RestBlogController {

    @Autowired
    private PostJDBCTemplate postJDBCTemplate;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity listPosts(Model model) {
        List<BlogPost> posts = postJDBCTemplate.getAllPost();
        return new ResponseEntity(posts, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity addPost(@RequestBody BlogPost post) {
        postJDBCTemplate.createPost(post.getAuthor(), post.getDate(), post.getTitle(), post.getContent());
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{postId}")
    public ResponseEntity getPost(@PathVariable("postId") int postId) {
        BlogPost post = postJDBCTemplate.getPostById(postId);
        return new ResponseEntity(post, HttpStatus.OK);
    }
}
