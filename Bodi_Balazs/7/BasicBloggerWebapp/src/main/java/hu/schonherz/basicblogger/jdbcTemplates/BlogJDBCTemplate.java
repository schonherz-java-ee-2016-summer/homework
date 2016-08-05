package hu.schonherz.basicblogger.jdbcTemplates;

import hu.schonherz.basicblogger.dao.BlogDao;
import hu.schonherz.basicblogger.mappers.BlogMapper;
import hu.schonherz.basicblogger.pojo.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by bmbal on 2016. 07. 31..
 */
@Repository
public class BlogJDBCTemplate implements BlogDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Blog getBlogById(int blog_id) {
        String sql = "SELECT id, author, title, content FROM public.blog WHERE id =" + blog_id + ";";
        Blog blog = jdbcTemplate.queryForObject(sql, new BlogMapper());
        return blog;
    }

    @Override
    public List<Blog> getAllBlog() {
        String sql = "SELECT id, author, title, content FROM public.blog;";
        List<Blog> blogs = jdbcTemplate.query(sql, new BlogMapper());
        return blogs;
    }

    @Override
    public void createBlog(Blog blog) {
        String sql = "Insert into public.\"blog\" (author, title, content) VALUES (?,?,?);";
        jdbcTemplate.update(sql, blog.getAuthor(), blog.getTitle(), blog.getContent());
    }
}
