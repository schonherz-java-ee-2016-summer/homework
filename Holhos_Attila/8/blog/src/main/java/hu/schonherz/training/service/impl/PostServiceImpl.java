package hu.schonherz.training.service.impl;

import hu.schonherz.training.models.Comment;
import hu.schonherz.training.models.Post;
import hu.schonherz.training.repository.PostRepository;
import hu.schonherz.training.service.PostService;
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
public class PostServiceImpl implements PostService{

    @Autowired
    private PostRepository postRepository;

    @Transactional
    public PostVo getPostByID(Long id) {
        Post post = postRepository.findById(id);
        PostVo postVo = toVo(post);
        return postVo;
    }

    @Transactional
    public List<PostVo> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        List<PostVo> postVos = new ArrayList<PostVo>();
        for (Post post: posts){
            postVos.add(toVo(post));
        }
        return postVos;
    }

    @Transactional
    public void createPost(PostVo postVo) {
        postRepository.save(toEntity(postVo));
    }

    public static PostVo toVo(Post post){
        PostVo postVo = new PostVo(post.getId(), post.getAuthor(), post.getPostDate(), post.getTitle(), post.getContent());
        for(Comment comment: post.getComments()){
            postVo.getCommentVos().add(CommentServiceImpl.toVo(comment));
        }
        return postVo;
    }

    public static Post toEntity(PostVo postVo){
        Post post = new Post(postVo.getId(), postVo.getAuthor(), postVo.getPostDate(), postVo.getTitle(), postVo.getContent());
        for(CommentVo commentVo: postVo.getCommentVos()){
            post.getComments().add(CommentServiceImpl.toEntity(commentVo));
        }
        return post;
    }
}
