package hu.schonherz.training.bloggyak.service;

import hu.schonherz.training.bloggyak.data.entities.CommentEntity;
import hu.schonherz.training.bloggyak.repository.CommentRepository;
import hu.schonherz.training.bloggyak.data.entities.PostEntity;
import hu.schonherz.training.bloggyak.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.ArrayList;

/**
 * Created by Lenovo on 2016.08.07..
 */

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public List<CommentEntity> getAllPostCommentsById(Long postId) {
        List<CommentEntity> comments = commentRepository.findAllByPostId(postId);
        return comments;
    }

    @Transactional
    @Override
    public void newComment(CommentEntity comment) {
        PostEntity post = postRepository.findById(comment.getId());
        List<CommentEntity> comments = post.getComments();
        if (comments == null){
            post.setComments(new ArrayList<CommentEntity>());
        }
        comments.add(comment);
        postRepository.save(post);
    }
}
