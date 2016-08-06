package hu.schonherz.training.rest;

import hu.schonherz.training.models.Comment;
import hu.schonherz.training.models.Post;
import hu.schonherz.training.repository.CommentRepository;
import hu.schonherz.training.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Attila on 2016.07.29..
 */

@RestController
@RequestMapping(path = "/api", produces = "application/json")
public class RestBlogController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @RequestMapping(path = "/getAllPosts", method = RequestMethod.GET)
    public ResponseEntity listPosts(Model model) {
        List<Post> posts = postRepository.findAll();
        return new ResponseEntity(posts, HttpStatus.OK);
    }

    @RequestMapping(path = "/getPostComments/{postID}", method = RequestMethod.GET)
    public ResponseEntity getCommets(@PathVariable("postID") Long postID, Model model){
        List<Comment> comments = commentRepository.findByPostid(postID);
        return new ResponseEntity(comments, HttpStatus.OK);
    }

    @RequestMapping(path = "/newPost", method = RequestMethod.POST)
    public ResponseEntity addPost(@RequestBody Post post) {
        postRepository.save(post);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(path = "/newComment/{postID}", method = RequestMethod.POST)
    public ResponseEntity addComment(@RequestBody Comment comment, @PathVariable("postID") Long postID){
        Post post = postRepository.findById(comment.getPostID());
        List<Comment> comments = post.getComments();
        if (comments == null){
            post.setComments(new ArrayList<Comment>());
        }
        comments.add(comment);
        postRepository.save(post);
        return new ResponseEntity(HttpStatus.OK);
    }
}
