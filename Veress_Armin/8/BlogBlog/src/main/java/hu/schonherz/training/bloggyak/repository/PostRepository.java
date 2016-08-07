package hu.schonherz.training.bloggyak.repository;

import hu.schonherz.training.bloggyak.data.entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Lenovo on 2016.08.07..
 */

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long>{

    List<PostEntity> findAll();

    PostEntity findById(Long id);

}
