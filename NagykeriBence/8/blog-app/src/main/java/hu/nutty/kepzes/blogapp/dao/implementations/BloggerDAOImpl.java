package hu.nutty.kepzes.blogapp.dao.implementations;

import hu.nutty.kepzes.blogapp.beans.Blogger;
import hu.nutty.kepzes.blogapp.dao.BloggerDAO;
import hu.nutty.kepzes.blogapp.mapper.BloggerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Nutty on 2016.07.25..
 */
@Repository
public class BloggerDAOImpl implements BloggerDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private SimpleJdbcInsert simpleJdbcInsert;

    @Override
    public Blogger getBloggerByNickName(String nickName) {
        String sql = "SELECT bloggerID, firstName, lastName, nickName, age FROM public.\"Bloggers\" WHERE nickName = ?";
        Blogger blogger = jdbcTemplate.queryForObject(sql, new Object[]{nickName}, new BloggerMapper());
        return blogger;
    }

    @Override
    public Blogger getBloggerById(int bloggerID) {
        String sql = "SELECT bloggerID, firstName, lastName, nickName, age FROM public.\"Bloggers\" WHERE bloggerID = ?";
        Blogger blogger = jdbcTemplate.queryForObject(sql, new Object[]{bloggerID}, new BloggerMapper());

        return blogger;
    }

    @Override
    public List<Blogger> getAllBloggers() {
        String sql = "SELECT bloggerID, firstName, lastName, nickName, age FROM public.\"Bloggers\"";
        List<Blogger> bloggers = jdbcTemplate.query(sql, new BloggerMapper());
        return bloggers;
    }

    @Override
    public void addBlogger(Blogger blogger) {
        String sql = "INSERT INTO public.\"Bloggers\" (firstName, lastName, nickName, age) VALUES (?,?,?,?) ;";
        jdbcTemplate.update(sql, blogger.getFirstName(), blogger.getLastName(), blogger.getNickName(), blogger.getAge());
    }

    @Override
    public int addBloggerAndReturnId(Blogger blogger) {
        simpleJdbcInsert.withTableName("Bloggers");
        simpleJdbcInsert.usingGeneratedKeyColumns("bloggerid");
        Map args = new HashMap();
        args.put("firstname", blogger.getFirstName());
        args.put("lastname", blogger.getLastName());
        args.put("nickname", blogger.getNickName());
        args.put("age", blogger.getAge());

        return simpleJdbcInsert.executeAndReturnKey(args).intValue();
    }

    @Override
    public void updateBlogger(Blogger blogger) {

    }

    @Override
    public void deleteBlogger(Blogger blogger) {

    }
}
