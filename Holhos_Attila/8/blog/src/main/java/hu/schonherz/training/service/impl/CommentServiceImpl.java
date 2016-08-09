package hu.schonherz.training.service.impl;

import hu.schonherz.training.models.Comment;
import hu.schonherz.training.models.Post;
import hu.schonherz.training.repository.CommentRepository;
import hu.schonherz.training.repository.PostRepository;
import hu.schonherz.training.service.CommentService;
import hu.schonherz.training.vo.CommentVo;
import hu.schonherz.training.vo.PostVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Attila on 2016.07.27..
 */

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Transactional
    public List<CommentVo> getAllCommentByPostId(Long postId) {
        List<Comment> comments = commentRepository.findByPostid(postId);
        List<CommentVo> commentVos = new ArrayList<CommentVo>();
        for (Comment comment: comments){
            commentVos.add(toVo(comment));
        }
        return commentVos;
    }

    @Transactional
    public void createComment(CommentVo commentVo) {
        Post post = postRepository.findOne(commentVo.getPostid());
        List<Comment> comments = post.getComments();
        if (comments == null){
            post.setComments(new ArrayList<Comment>());
        }
        comments.add(toEntity(commentVo));
        postRepository.save(post);
    }

    public static CommentVo toVo(Comment comment){
        return new CommentVo(comment.getId(), comment.getPostID(), comment.getCommentDate(), comment.getContent());
    }

    public static Comment toEntity(CommentVo commentVo){
        return new Comment(commentVo.getId(), commentVo.getPostid(), commentVo.getCommentDate(),commentVo.getContent());
    }
}
