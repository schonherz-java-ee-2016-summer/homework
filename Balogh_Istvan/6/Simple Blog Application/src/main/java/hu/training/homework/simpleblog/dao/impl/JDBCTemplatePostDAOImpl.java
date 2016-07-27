package hu.training.homework.simpleblog.dao.impl;

import hu.training.homework.simpleblog.dao.PostDAO;
import hu.training.homework.simpleblog.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Timestamp;
import java.util.List;

@Repository
public class JDBCTemplatePostDAOImpl implements PostDAO {

    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public JDBCTemplatePostDAOImpl(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void addPost(Post post) {
        String sql = "INSERT INTO public.\"Post\" (id, author, dateandtime, title, contentofpost) VALUES (?,?,?,?,?)";
        Timestamp ts = Timestamp.valueOf(post.getDateTime());
        jdbcTemplate.update(sql, post.getId(), post.getAuthor(), ts, post.getTitle(), post.getContent());
    }

    @Override
    public Post getPostByID(String id) {
        return null;
    }

    @Override
    public List<Post> getAllPosts() {
        return null;
    }

    @Override
    public void updatePost(Post post) {

    }

    @Override
    public void deletePost(Post post) {

    }
}
