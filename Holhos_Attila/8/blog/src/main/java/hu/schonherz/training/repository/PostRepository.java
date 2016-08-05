package hu.schonherz.training.repository;

import hu.schonherz.training.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Attila on 2016.08.05..
 */

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

    List<Post> findAll();

    Post findById(Long id);

}
