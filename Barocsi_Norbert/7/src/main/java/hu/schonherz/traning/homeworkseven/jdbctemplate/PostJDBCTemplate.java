package hu.schonherz.traning.homeworkseven.dao.jdbctemplate;

import hu.schonherz.traning.homeworkseven.dao.dao.PostDao;
import hu.schonherz.traning.homeworkseven.dao.mapper.PostMapper;
import hu.schonherz.traning.homeworkseven.dao.pojo.Post;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.Date;
import java.util.List;

/**
 * Created by Mindfield on 2016. 07. 31..
 */
public class PostJDBCTemplate implements PostDao{

    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Post> getAllPost() {
        String sql = "SELECT id, creator, date, title, text FROM public.\"Blog\";";
        List<Post> posts = jdbcTemplate.query(sql, new PostMapper());

        return posts;
    }

    @Override
    public Post getPostById(int identity) {
        String sql = "SELECT id, creator, date, title, text FROM public.\"Blog\" WHERE id = ?;";
        Post post = jdbcTemplate.queryForObject(sql, new PostMapper(), identity);

        return post;
    }

    @Override
    public void createPost(String creator, String title, String text) {
        String sql = "INSERT INTO public.\"Blog\"(creator, date, title, text) VALUES (?, ?, ?, ?);";
        jdbcTemplate.update(sql, creator, new Date(), title, text);
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
