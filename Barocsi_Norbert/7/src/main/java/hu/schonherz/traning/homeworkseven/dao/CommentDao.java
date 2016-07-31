package hu.schonherz.traning.homeworkseven.dao.dao;

import hu.schonherz.traning.homeworkseven.dao.pojo.Comment;

import java.util.Date;
import java.util.List;

/**
 * Created by Mindfield on 2016. 07. 31..
 */
public interface CommentDao {

    List<Comment> getAllCommentByPostId(int blogId);

    void createComment(int blogIdentity, String comment);
}
