package hu.schonherz.training.repository;

import hu.schonherz.training.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Attila on 2016.08.05..
 */

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long>{

    List<Comment> findByPostid(Long postid);

}
