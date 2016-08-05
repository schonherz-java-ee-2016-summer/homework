package hu.training.homework.simpleblog.dao.impl;

import hu.training.homework.simpleblog.dao.PostDAO;
import hu.training.homework.simpleblog.model.Post;
import hu.training.homework.simpleblog.util.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public class JDBCTemplatePostDAOImpl implements PostDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void addPost(Post post) {
        String sql = "INSERT INTO public.\"Post\" (id, author, dateandtime, title, contentofpost) VALUES (?,?,?,?,?)";
        Timestamp ts = Timestamp.valueOf(post.getDateTime());
        jdbcTemplate.update(sql, post.getId(), post.getAuthor(), ts, post.getTitle(), post.getContent());
    }

    @Override
    public Post getPostByID(String id) {
        String sql = "SELECT id, author, dateandtime, title, contentofpost FROM public.\"Post\" WHERE id = ?;";
        Post post = jdbcTemplate.queryForObject(sql, new PostMapper(), id);
        return post;
    }

    @Override
    public List<Post> getAllPosts() {
        return jdbcTemplate.query("SELECT id, author, dateandtime, title, contentofpost FROM public.\"Post\";",
                new PostMapper());
    }

}
