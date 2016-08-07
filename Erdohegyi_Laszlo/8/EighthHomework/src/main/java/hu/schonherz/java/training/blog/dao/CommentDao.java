package hu.schonherz.java.training.blog.dao;

import hu.schonherz.java.training.blog.entity.BlogComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDao extends JpaRepository<BlogComment, Long> {

    List<BlogComment> getCommentByPostId(Long postId);

}
