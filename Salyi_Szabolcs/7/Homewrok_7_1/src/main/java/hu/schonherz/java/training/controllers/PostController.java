package hu.schonherz.java.training.controllers;


import hu.schonherz.java.training.dao.CommentDao;
import hu.schonherz.java.training.dao.PostDao;

/**
 * Created by Home on 2016. 08. 01..
 */

@Controller
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostDao postDao;

    @Autowired
    private CommentDao commentDao;

    @RequestMapping(path="/id", method = RequestMethod.GET)
    public
}
