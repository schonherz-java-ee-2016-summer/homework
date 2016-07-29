package hu.nutty.kepzes.blogapp.mapper;

import hu.nutty.kepzes.blogapp.beans.Blogger;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BloggerMapper implements RowMapper<Blogger> {
    @Override
    public Blogger mapRow(ResultSet rs, int rowNum) throws SQLException {
        Blogger blogger = new Blogger(
                rs.getInt("bloggerid"),
                rs.getString("firstname"),
                rs.getString("lastname"),
                rs.getString("nickname"),
                rs.getInt("age")
        );
        return blogger;
    }
}
