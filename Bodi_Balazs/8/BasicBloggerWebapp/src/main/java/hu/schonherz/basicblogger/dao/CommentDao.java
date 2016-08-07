package hu.schonherz.basicblogger.dao;

import hu.schonherz.basicblogger.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by bmbal on 2016.08.06..
 */
@Repository
public interface CommentDao extends JpaRepository<Comment, Long> {

    public List<Comment> getByBlogId(Long postid);

}
