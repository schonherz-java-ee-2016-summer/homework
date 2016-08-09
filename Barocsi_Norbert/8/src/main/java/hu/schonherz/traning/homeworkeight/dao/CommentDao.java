package hu.schonherz.traning.homeworkeight.dao;

import hu.schonherz.traning.homeworkeight.pojo.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mindfield on 2016. 08. 06..
 */
@Repository
public interface CommentDao extends JpaRepository<Comment, Long>{

    List<Comment> getCommentByBlogIdentity(Long postId);


}
