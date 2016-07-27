package hu.nutty.kepzes.blogapp.mapper;

import hu.nutty.kepzes.blogapp.beans.BlogPost;
import hu.nutty.kepzes.blogapp.beans.Blogger;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;


public class BloggerMapper implements RowMapper<Blogger> {

    @Override
    public Blogger mapRow(ResultSet rs, int rowNum) throws SQLException {
        Blogger blogger = new Blogger();
        blogger.setFirstName(rs.getString("fistname"));
        blogger.setLastName(rs.getString("lastname"));
        blogger.setNickName(rs.getString("nickname"));
        blogger.setAge(rs.getInt("age"));

        return blogger;
    }
}
