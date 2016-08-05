package hu.schonherz.traning.homeworkseven.rest;

import hu.schonherz.traning.homeworkseven.jdbctemplate.PostJDBCTemplate;
import hu.schonherz.traning.homeworkseven.pojo.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Mindfield on 2016. 08. 01..
 */
@RestController
@RequestMapping(path = "/rest/posts", produces = "application/json")
public class RestBlogController {

    @Autowired
    private PostJDBCTemplate postJDBCTemplate;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity listPosts(Model model) {
        List<Post> blogs = postJDBCTemplate.getAllPost();
        return new ResponseEntity(blogs, HttpStatus.OK);
    }

    @RequestMapping(path = "/addpost", method = RequestMethod.POST)
    public ResponseEntity addPost(@RequestBody Post post) {
        postJDBCTemplate.createPost(post.getCreator(), post.getTitle(), post.getText());
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getBlog(@PathVariable("id") int postId) {
        Post post = postJDBCTemplate.getPostById(postId);
        return new ResponseEntity(post, HttpStatus.OK);
    }
}
