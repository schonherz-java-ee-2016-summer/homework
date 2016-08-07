package hu.schonherz.training.bloggyak.data.dao.impl;

import hu.schonherz.training.bloggyak.data.dao.CommentDAO;
import hu.schonherz.training.bloggyak.data.dao.constants.Queries;
import hu.schonherz.training.bloggyak.data.dao.rowmappers.CommentRowMapper;
import hu.schonherz.training.bloggyak.data.entities.CommentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * Created by Lenovo on 2016.07.29..
 */
public class CommentDAOImpl implements CommentDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(CommentEntity comment) {
        jdbcTemplate.update(Queries.INSERT_COMMENT,
                comment.getPostId(),
                comment.getAuthor(),
                comment.getContent()
        );
    }

    public List<CommentEntity> findAllByPostId(int postId) {
        return jdbcTemplate.query(Queries.SELECT_COMMENTS_OF_POST, new CommentRowMapper(), postId);
    }
}
