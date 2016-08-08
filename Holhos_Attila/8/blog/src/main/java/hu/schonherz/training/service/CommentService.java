package hu.schonherz.training.service;

import hu.schonherz.training.vo.CommentVo;
import java.util.List;

/**
 * Created by Attila on 2016.08.06..
 */
public interface CommentService {

    List<CommentVo> getAllCommentByPostId(Long postId);

    void createComment(CommentVo commentVo);
}
