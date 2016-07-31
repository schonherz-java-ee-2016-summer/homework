package hu.schonherz.basicblogger.dao;

import hu.schonherz.basicblogger.pojo.Blog;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bmbal on 2016. 07. 30..
 *  this.id = id;
 this.author = author;
 this.date = date;
 this.title = title;
 this.content = content;
 */
public class BlogDao {

    private Connection con;

    public List<Blog> getAllBlogs(){
        List<Blog> result = new ArrayList<>();
        return result;
    };


    public List<Blog> getAllStudents() {
        String sql = "SELECT * FROM public.\"student\"";
        List<Blog> blogs = new ArrayList<>();
        try (Statement stmt = con.createStatement()) {
            try (ResultSet rs = stmt.executeQuery(sql);) {
                while (rs.next()) {
         //           blogs.add(new Blog(rs.getInt("id"), rs.getString("author"), rs.getDate("date"), rs.getString("title"), rs.getString("content")));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return blogs;
    }

    public void addBlog(Blog blog){

    }

}
