/*
package hu.training.homework.springblog.rest;

import hu.training.homework.springblog.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rest/posts", produces = "application/json")
public class RestPostController {

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity loadRestIndex() {
        List<Post> posts = postDAO.getAllPosts();
        return new ResponseEntity(posts, HttpStatus.OK);
    }

    @RequestMapping(path = "/addpost", method = RequestMethod.POST)
    public ResponseEntity addPost(@RequestBody Post post) {
        postDAO.addPost(post);
        return new ResponseEntity(HttpStatus.OK);
    }

}
*/
