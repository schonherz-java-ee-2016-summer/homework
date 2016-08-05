package hu.schonherz.java.training.dao.impl;

import hu.schonherz.java.training.dao.PostDao;
import hu.schonherz.java.training.dbconnection.PostgreSQLConnection;
import hu.schonherz.java.training.mappers.PostMapper;
import hu.schonherz.java.training.pojo.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Home on 2016. 07. 28..
 */

@Repository
public class PostDaoImpl implements PostDao {


    private Connection conn;

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public PostDaoImpl(JdbcTemplate jdbcTemplate) {

        try{
            conn = PostgreSQLConnection.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Post> getAllPost() {
        String sql = "SELECT * FROM public.\"Blog\"";
        List<Post> posts = jdbcTemplate.query(sql, new PostMapper());
        return posts;
    }

    @Override
    public Post getPostById(int blogId) {
        String sql = "SELECT * FROM public.\"Blog\" WHERE id = ?";
        Post post = jdbcTemplate.queryForObject(sql, new Object[]{blogId}, new PostMapper());
        return post;
    }

    @Override
    public void addPost(String title, String author, String content) {

        String sql = "INSERT INTO public.\"Blog\" (title, author, content) VALUES(?,?,?)";
        jdbcTemplate.update(sql, title, author, content);

    }
}
