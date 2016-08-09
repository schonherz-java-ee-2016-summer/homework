package hu.schonherz.traning.homeworkeight.rest;

import hu.schonherz.traning.homeworkeight.pojo.Post;
import hu.schonherz.traning.homeworkeight.service.PostService;
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
    private PostService postService;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity listPosts(Model model) {
        List<Post> blogs = postService.getAllPost();
        return new ResponseEntity(blogs, HttpStatus.OK);
    }

    @RequestMapping(path = "/addpost", method = RequestMethod.POST)
    public ResponseEntity addPost(@RequestBody Post post) {
        postService.createPost(post);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getBlog(@PathVariable("id") Long postId) {
        Post post = postService.getPostByIdentity(postId);
        return new ResponseEntity(post, HttpStatus.OK);
    }
}
