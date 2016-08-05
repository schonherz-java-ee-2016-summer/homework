package hu.schonherz.java.training.jdbctemplate;

import hu.schonherz.java.training.dao.PostDao;
import hu.schonherz.java.training.mappers.PostMapper;
import hu.schonherz.java.training.pojo.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Home on 2016. 08. 03..
 */

@Repository
public class PostDaoImpl implements PostDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Post> getAllPost() {
        String sql = "SELECT id, author , title , text FROM public.\"Blog\";";
        List <Post> posts = jdbcTemplate.query(sql, new PostMapper());
        return posts;
    }

    @Override
    public void addPost(String author, String title, String content) {
        String sql = "INSERT INTO public.\"Blog\" (author , title , text) VALUES (?,?,?);";
        jdbcTemplate.update( sql, author , title , content);
    }

    @Override
    public Post getPostById(int id) {
        String sql = "SELECT id , author , title , text FROM public.\"Blog\" WHERE id = ?;";
        Post post = (Post) jdbcTemplate.queryForObject(sql , new PostMapper() , id);
        return post;
    }
}
