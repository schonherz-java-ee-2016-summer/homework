package hu.schonherz.training.rest;

import hu.schonherz.training.dao.CommentDao;
import hu.schonherz.training.dao.PostDao;
import hu.schonherz.training.models.Comment;
import hu.schonherz.training.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Attila on 2016.07.29..
 */

@RestController
@RequestMapping(path = "/api", produces = "application/json")
public class RestBlogController {

    @Autowired
    private PostDao postDao;

    @Autowired
    private CommentDao commentDao;

    @RequestMapping(path = "/getAllPosts", method = RequestMethod.GET)
    public ResponseEntity listPosts(Model model) {
        List<Post> posts = postDao.getAllPosts();
        return new ResponseEntity(posts, HttpStatus.OK);
    }

    @RequestMapping(path = "/getPostComments/{postID}", method = RequestMethod.GET)
    public ResponseEntity getCommets(@PathVariable("postID") int postID, Model model){
        List<Comment> comments = commentDao.getAllCommentByPostId(postID);
        return new ResponseEntity(comments, HttpStatus.OK);
    }

    @RequestMapping(path = "/newPost", method = RequestMethod.POST)
    public ResponseEntity addPost(@RequestBody Post post) {
        postDao.createPost(post);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(path = "/newComment/{postID}", method = RequestMethod.POST)
    public ResponseEntity addComment(@RequestBody Comment comment, @PathVariable("postID") int postID){
        commentDao.createComment(postID,comment);
        return new ResponseEntity(HttpStatus.OK);
    }
}
