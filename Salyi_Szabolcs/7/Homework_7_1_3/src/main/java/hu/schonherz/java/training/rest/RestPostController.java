package hu.schonherz.java.training.rest;

import hu.schonherz.java.training.dao.PostDao;
import hu.schonherz.java.training.pojo.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Home on 2016. 08. 01..
 */

@RestController
@RequestMapping(path = "/rest/post", produces = "application/json")
public class RestPostController {

    @Autowired
    private PostDao postDao;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity allPosts(Model model){
        List<Post> posts = postDao.getAllPost();
        return new ResponseEntity(posts, HttpStatus.OK);
    }

    @RequestMapping(path = "/new", method = RequestMethod.POST)
    public ResponseEntity addPost(@RequestBody Post post){
        postDao.addPost(post.getTitle(),post.getAuthor(),post.getContent());
        return new ResponseEntity(HttpStatus.OK);
    }



}
