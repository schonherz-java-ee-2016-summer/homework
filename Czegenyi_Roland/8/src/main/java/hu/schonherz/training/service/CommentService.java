package hu.schonherz.training.service;

import hu.schonherz.training.vo.CommentVo;

/**
 * Created by Roli on 2016. 08. 07..
 */
public interface CommentService {

    void addCommnet(CommentVo commentVo, Long blogId);
}
