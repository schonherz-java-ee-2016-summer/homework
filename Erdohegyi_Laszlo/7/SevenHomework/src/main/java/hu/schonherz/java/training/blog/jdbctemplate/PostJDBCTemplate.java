package hu.schonherz.java.training.blog.jdbctemplate;

import hu.schonherz.java.training.blog.dao.PostDao;
import hu.schonherz.java.training.blog.mapper.PostMapper;
import hu.schonherz.java.training.blog.model.BlogPost;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;


public class PostJDBCTemplate implements PostDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<BlogPost> getAllPost() {
        String sql = "SELECT id, author, title, content FROM public.\"POST\";";
        List<BlogPost> posts = jdbcTemplate.query(sql, new PostMapper());
        return posts;
    }

    @Override
    public BlogPost getPostById(int id) {
        String sql = "SELECT id, author, title, content FROM public.\"POST\" WHERE id = ?;";
        BlogPost post = jdbcTemplate.queryForObject(sql, new PostMapper(), id);
        return post;
    }

    @Override
    public void createPost(String author, String title, String content) {
        String sql = "INSERT INTO public.\"POST\"(author, title, content) VALUES (?, ?, ?);";
        jdbcTemplate.update(sql, author, title, content);
    }

}
