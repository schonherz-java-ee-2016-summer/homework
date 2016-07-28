package hu.nutty.kepzes.blogapp.dao.implementations;

import hu.nutty.kepzes.blogapp.beans.Blogger;
import hu.nutty.kepzes.blogapp.dao.BloggerDAO;
import hu.nutty.kepzes.blogapp.mapper.BloggerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Nutty on 2016.07.25..
 */
@Repository
public class BloggerDAOImpl implements BloggerDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void createBloggersTable() {
        String createTableSQL = "CREATE TABLE public.\"Bloggers\"(" +
                "bloggerID integer PRIMARY KEY," +
                "firstName varchar," +
                "lastName varchar," +
                "nickName varchar," +
                "age integer" +
                ");";
        jdbcTemplate.execute(createTableSQL);
    }

    public void deleteBloggersTable() {
        String dropTableSQL = "DROP TABLE IF EXISTS public.\"Bloggers\" CASCADE;";
        jdbcTemplate.execute(dropTableSQL);
    }

    @Override
    public Blogger getBloggerByNickName(String nickName) {
        String sql = "SELECT bloggerID, firstName, lastName, nickName, age FROM public.\"Bloggers\" WHERE nickName = ?";
        Blogger blogger = jdbcTemplate.queryForObject(sql, new Object[]{nickName}, (resultSet, index) -> {
            Blogger b = new Blogger(
                    resultSet.getInt("bloggerID"), resultSet.getString("firstName"),
                    resultSet.getString("lastName"), resultSet.getString("nickName"),
                    resultSet.getInt("age")
            );
            return b;
        });
        return blogger;
    }

    @Override
    public Blogger getBloggerById(int bloggerID) {
        String sql = "SELECT bloggerID, firstName, lastName, nickName, age FROM public.\"Bloggers\" WHERE bloggerID = ?";
        Blogger blogger = jdbcTemplate.queryForObject(sql, new Object[]{bloggerID}, (resultSet, index) -> {
            Blogger b = new Blogger(
                    resultSet.getInt("bloggerID"), resultSet.getString("firstName"),
                    resultSet.getString("lastName"), resultSet.getString("nickName"),
                    resultSet.getInt("age")
            );
            return b;
        });

        return blogger;
    }

    @Override
    public List<Blogger> getAllBloggers() {
        String sql = "SELECT bloggerID, firstName, lastName, nickName, age FROM public.\"Bloggers\"";
        List<Blogger> bloggers = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Blogger>());
        return bloggers;
    }

    @Override
    public void addBlogger(Blogger blogger) {
        String sql = "INSERT INTO public.\"Bloggers\" (bloggerID, firstName, lastName, nickName, age) VALUES (?,?,?,?,?) ;";
        jdbcTemplate.update(sql, blogger.getBloggerID(), blogger.getFirstName(), blogger.getLastName(), blogger.getNickName(), blogger.getAge());
    }

    @Override
    public void updateBlogger(Blogger blogger) {

    }

    @Override
    public void deleteBlogger(Blogger blogger) {

    }
}
