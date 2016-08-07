package hu.schonherz.training.bloggyak.repository;

import hu.schonherz.training.bloggyak.data.entities.CommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Lenovo on 2016.08.07..
 */

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, Long>{

    List<CommentEntity> findAllByPostId(Long postid);

}
