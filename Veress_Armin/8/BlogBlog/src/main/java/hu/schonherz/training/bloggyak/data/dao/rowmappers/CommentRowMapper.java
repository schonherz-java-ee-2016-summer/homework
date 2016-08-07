package hu.schonherz.training.bloggyak.data.dao.rowmappers;

import hu.schonherz.training.bloggyak.data.entities.CommentEntity;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * Created by Lenovo on 2016.07.29..
 */
public class CommentRowMapper implements RowMapper<CommentEntity> {
    @Override
    public CommentEntity mapRow(ResultSet resultSet, int i) throws SQLException {
        CommentEntity comment = new CommentEntity();
        comment.setId(resultSet.getInt("id"));
        comment.setPostId(resultSet.getInt("postId"));
        comment.setAuthor(resultSet.getString("author"));
        comment.setContent(resultSet.getString("content"));
        comment.setDate(resultSet.getTimestamp("date").toLocalDateTime());
        return comment;
    }
}
