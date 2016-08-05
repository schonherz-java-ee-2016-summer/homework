package hu.schonherz.training.service;

import hu.schonherz.training.dao.CommentDao;
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
public class CommentService implements CommentDao {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<Comment> getAllCommentByPostId(Long postId) {
        List<Comment> comments = commentRepository.findByPostId(postId);
        return comments;
    }

    @Override
    public void createComment(Long postId, Comment comment) {
        Post post = postRepository.findOne(postId);
        List<Comment> comments = post.getComments();
        if(comments==null){
            post.setComments(new ArrayList<Comment>());
        }
        comments.add(comment);
        postRepository.save(post);
    }
}
