package hu.schonherz.training.bloggyak.data.dao.impl;

import hu.schonherz.training.bloggyak.data.dao.PostDAO;
import hu.schonherz.training.bloggyak.data.dao.constants.Queries;
import hu.schonherz.training.bloggyak.data.dao.rowmappers.PostRowMapper;
import hu.schonherz.training.bloggyak.data.pojo.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Lenovo on 2016.07.29..
 */
@Repository
public class PostDAOImpl implements PostDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void save(Post post) {
        jdbcTemplate.update(Queries.INSERT_POST, new Object[]{
                post.getAuthor(),
                post.getTitle(),
                post.getContent(),
                post.getDate()});
    }

    public List<Post> findAll() {
        return jdbcTemplate.query(Queries.SELECT_ALL_POSTS, new PostRowMapper());
    }

    public Post findById(int id) {
        return jdbcTemplate.queryForObject(Queries.SELECT_POST, new PostRowMapper(), id);
    }
}
