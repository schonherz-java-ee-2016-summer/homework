package hu.schonherz.java.training.repository;

import hu.schonherz.java.training.pojo.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Home on 2016. 08. 03..
 */

@Repository
@Transactional
public interface CommentDao extends JpaRepository<Comment , Long>{

    List<Comment> getAllCommentById(Long postId);

    //void addComment(int blogId, String comment);
}
