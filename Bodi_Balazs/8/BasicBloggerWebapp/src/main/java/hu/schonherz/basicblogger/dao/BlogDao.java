package hu.schonherz.basicblogger.dao;

import hu.schonherz.basicblogger.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by bmbal on 2016.08.06..
 */
@Repository
public interface BlogDao extends JpaRepository<Blog, Long> {

    public List<Blog> findAll();

    public Blog findById(Long id);

}