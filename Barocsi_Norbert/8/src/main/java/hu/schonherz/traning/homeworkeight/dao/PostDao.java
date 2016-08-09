package hu.schonherz.traning.homeworkeight.dao;

import hu.schonherz.traning.homeworkeight.pojo.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Mindfield on 2016. 08. 06..
 */
@Repository
public interface PostDao extends JpaRepository<Post, Long>{

    List<Post> findAll();

    Post findByIdentity(Long id);
}
