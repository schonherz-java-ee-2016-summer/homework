package hu.schonherz.java.training.dao.impl;

import hu.schonherz.java.training.dao.CommentDao;
import hu.schonherz.java.training.dbconnection.PostgreSQLConnection;
import hu.schonherz.java.training.mappers.CommentMapper;
import hu.schonherz.java.training.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Home on 2016. 07. 27..
 */

@Repository
public class CommentDaoImpl implements CommentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addComment(int blogId, String comment) {
        String sql = "INSERT INTO public.\"Comment\" (blogId, comment) VALUES (?,?)";
        try(Connection conn = PostgreSQLConnection.getConnection()) {

            jdbcTemplate.update(sql,blogId, comment);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<Comment> getAllCommnetById(int blogId) {
        String sql = "SELECT * FROM public.\"Comment\"";
        List<Comment>  comments = new ArrayList<>();
        try(Connection conn = PostgreSQLConnection.getConnection()) {
            comments = jdbcTemplate.query(sql, new CommentMapper());
        }catch (SQLException e){
            e.printStackTrace();
        }
        return comments;
    }
}
