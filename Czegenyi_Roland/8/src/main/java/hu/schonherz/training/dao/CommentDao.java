package hu.schonherz.training.dao;

import hu.schonherz.training.pojo.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.metamodel.Metamodel;
import java.util.List;
import java.util.Map;

/**
 * Created by Roli on 2016. 07. 28..
 */

//TODO: rename and fix comments

@Repository
@Transactional(propagation = Propagation.SUPPORTS)
public interface CommentDao extends JpaRepository<Comment, Long> {

    @Query("select b.comments from Comment c, Blog  b where b.id = :blogid")
    List<Comment> findAll(@Param("blogid") Long blogid);


    Comment save(Comment persisted);

}

