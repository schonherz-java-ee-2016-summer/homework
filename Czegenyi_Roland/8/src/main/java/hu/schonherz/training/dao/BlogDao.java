package hu.schonherz.training.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import hu.schonherz.training.pojo.Blog;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Roli on 2016. 07. 28..
 */
//TODO: rename
public interface BlogDao extends JpaRepository<Blog, Long> {
    @Transactional(timeout = 20)
    List<Blog> findAll();

    Blog findById(Long id);

    Blog save(Blog persisted);

}
