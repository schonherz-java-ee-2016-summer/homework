package hu.schonherz.training.service;

import hu.schonherz.training.models.Comment;
import hu.schonherz.training.models.Post;
import hu.schonherz.training.repository.CommentRepository;
import hu.schonherz.training.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Attila on 2016.07.27..
 */

@Service
public class CommentService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    public List<Comment> getAllCommentByPostId(Long postId) {
        List<Comment> comments = commentRepository.findByPostid(postId);
        return comments;
    }

    public void createComment(Comment comment) {
        Post post = postRepository.findOne(comment.getPostID());
        List<Comment> comments = post.getComments();
        if (comments == null){
            post.setComments(new ArrayList<Comment>());
        }
        comments.add(comment);
        postRepository.save(post);
    }
}
