package hu.schonherz.basicblogger.dao;

import hu.schonherz.basicblogger.pojo.Blog;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bmbal on 2016.08.05..
 */

@Component("BlogDaoImpl")
public class BlogDaoImpl implements BlogDao {

    private Connection con;

    @Override
    public Blog getBlogById(int id) {
        return null;
    }

    @Override
    public List<Blog> getAllBlog()  {
        String sql = "SELECT * FROM public.\"Blog\"";
        List<Blog> blogs = new ArrayList<>();
        try (Statement stmt = con.createStatement()) {
            try (ResultSet rs = stmt.executeQuery(sql);) {
                while (rs.next()) {
                    blogs.add(new Blog(rs.getInt("id"), rs.getString("author"), rs.getString("title"), rs.getString("content")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return blogs;
    }

    @Override
    public void createBlog(Blog blog) {

    }
}
