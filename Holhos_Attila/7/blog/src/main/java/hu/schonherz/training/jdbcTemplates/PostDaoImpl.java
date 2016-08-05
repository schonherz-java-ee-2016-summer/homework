package hu.schonherz.training.jdbcTemplates;

import hu.schonherz.training.dao.PostDao;
import hu.schonherz.training.mappers.PostMapper;
import hu.schonherz.training.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.activation.DataSource;
import java.util.List;

/**
 * Created by Attila on 2016.07.27..
 */

@Repository
public class PostDaoImpl implements PostDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    /*@Autowired
    private SimpleJdbcInsert jdbcInsert;*/

    @Override
    public Post getPostByID(int id) {
        String sql = "Select * from \"Blog\".\"Post\" where id=?;";
        Post post = jdbcTemplate.queryForObject(sql, new PostMapper(), id);
        return post;
    }

    @Override
    public List<Post> getAllPosts() {
        String sql = "Select * from \"Blog\".\"Post\";";
        List<Post> posts = jdbcTemplate.query(sql, new PostMapper());
        return posts;
    }

    @Override
    public void createPost(Post post) {
        String sql = "Insert into \"Blog\".\"Post\" (author, title, postdate, content) VALUES (?,?,?,?);";
        jdbcTemplate.update(sql, post.getAuthor(), post.getTitle(), post.getPostDate(), post.getContent());
    }
}
