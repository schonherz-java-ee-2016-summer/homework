package hu.schonherz.traning.homeworkseven.jdbctemplate;

import hu.schonherz.traning.homeworkseven.dao.PostDao;
import hu.schonherz.traning.homeworkseven.mapper.PostMapper;
import hu.schonherz.traning.homeworkseven.pojo.Post;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * Created by Mindfield on 2016. 07. 31..
 */
public class PostJDBCTemplate implements PostDao{

    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Post> getAllPost() {
        String sql = "SELECT id, creator, time, title, text FROM public.\"Blog\";";
        List<Post> posts = jdbcTemplate.query(sql, new PostMapper());

        return posts;
    }

    @Override
    public Post getPostById(int identity) {
        String sql = "SELECT id, creator, time, title, text FROM public.\"Blog\" WHERE id = ?;";
        Post post = jdbcTemplate.queryForObject(sql, new PostMapper(), identity);

        return post;
    }

    @Override
    public void createPost(String creator, String title, String text) {
        String sql = "INSERT INTO public.\"Blog\"(creator, time, title, text) VALUES (?, ?, ?, ?);";
        Timestamp ts = Timestamp.valueOf(LocalDateTime.now());
        jdbcTemplate.update(sql, creator, ts, title, text);
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
