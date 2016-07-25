package hu.nutty.kepzes.blogapp.deprecated;

import hu.nutty.kepzes.blogapp.dao.BloggerDAO;
import hu.nutty.kepzes.blogapp.deprecated.ConnectionHandler;
import hu.nutty.kepzes.blogapp.beans.Blogger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nutty on 2016.07.25..
 */
public class BloggerDAOImplWithoutTemplate implements BloggerDAO {
    private Connection con;

    public BloggerDAOImplWithoutTemplate() {
        try {
            con = ConnectionHandler.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void executePreparedStatement(String sql) {
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createBloggersTable() {
        String createTableSQL = "CREATE TABLE public.\"Bloggers\"(" +
                "bloggerID integer PRIMARY KEY," +
                "firstName varchar," +
                "lastName varchar," +
                "nickName varchar," +
                "age integer" +
                ");";
        executePreparedStatement(createTableSQL);
    }

    public void deleteBloggersTable() {
        String dropTableSQL = "DROP TABLE IF EXISTS \"Bloggers\" CASCADE;";
        executePreparedStatement(dropTableSQL);
    }

    @Override
    public Blogger getBloggerByNickName(String nickName) {
        String sql = "SELECT bloggerID, firstName, lastName, nickName, age FROM public.\"Bloggers\" WHERE nickName = ?";
        Blogger blogger = null;
        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, nickName);
            try (ResultSet rs = stmt.executeQuery();) {
                while (rs.next()) {
                    blogger = new Blogger(
                            rs.getInt("bloggerID"), rs.getString("firstName"),
                            rs.getString("lastName"), rs.getString("nickName"),
                            rs.getInt("age")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return blogger;
    }

    @Override
    public List<Blogger> getAllBloggers() {
        String sql = "SELECT bloggerID, firstName, lastName, nickName, age FROM public.\"Bloggers\"";
        List<Blogger> bloggers = new ArrayList<>();
        try (Statement stmt = con.createStatement()) {
            try (ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    bloggers.add(
                            new Blogger(
                                    rs.getInt("bloggerID"), rs.getString("firstName"),
                                    rs.getString("lastName"), rs.getString("nickName"),
                                    rs.getInt("age")
                            )
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bloggers;
    }

    @Override
    public void addBlogger(Blogger blogger) {

    }

    @Override
    public void updateBlogger(Blogger blogger) {

    }

    @Override
    public void deleteBlogger(Blogger blogger) {

    }
}
