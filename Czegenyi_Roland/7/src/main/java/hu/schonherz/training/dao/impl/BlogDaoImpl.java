package hu.schonherz.training.dao.impl;

import hu.schonherz.training.dao.BlogDao;
import hu.schonherz.training.mapper.PostMapper;
import hu.schonherz.training.pojo.Blog;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roli on 2016. 07. 29..
 */
@Repository
public class BlogDaoImpl implements BlogDao {

    private JdbcTemplate jdbcTemplate;
    private DataSource dataSource;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Blog> getAllBlog() {
        List<Blog> blogs = new ArrayList<>();

        return jdbcTemplate.query("SELECT id, creator, title, date, text FROM public.\"Blog\";",
                ((resultSet, i) -> {
                   /* System.out.print(resultSet.getString("creator"));*/
                    Blog blog = new Blog();
                            blog.setId(resultSet.getInt("id"));
                            blog.setAuthor(resultSet.getString("creator"));
                            blog.setDate(resultSet.getTimestamp("date"));
                            blog.setTitle(resultSet.getString("title"));
                            blog.setContent(resultSet.getString("text"));

                    blogs.add(blog);
                    return blog;
                }
                ));
    }

    @Override
    public Blog getBlogById(int id) {

        return jdbcTemplate
                .queryForObject("SELECT id, creator, title, date, text FROM public.\"Blog\" WHERE id = ?;",
                        new PostMapper(), id);

    }

    @Override
    public void addBlog(Blog blog) {
        jdbcTemplate.update("INSERT INTO public.\"Blog\"(creator, date, title, text) VALUES (?, ?, ?, ?)",
                blog.getAuthor(),
                blog.getDate(),
                blog.getTitle(),
                blog.getContent()
        );
    }
}
