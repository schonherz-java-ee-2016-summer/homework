package hu.schonherz.java.training.blog.dao;

import hu.schonherz.java.training.blog.entity.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostDao extends JpaRepository<BlogPost, Long> {

    List<BlogPost> findAll();

    BlogPost findById(Long id);

}
