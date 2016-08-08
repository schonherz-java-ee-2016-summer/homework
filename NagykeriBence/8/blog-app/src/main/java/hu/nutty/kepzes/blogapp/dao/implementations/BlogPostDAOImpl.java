package hu.nutty.kepzes.blogapp.dao.implementations;

import hu.nutty.kepzes.blogapp.dao.BaseConvertDAO;
import hu.nutty.kepzes.blogapp.dao.BlogPostDAO;
import hu.nutty.kepzes.blogapp.dto.BlogPostDTO;
import hu.nutty.kepzes.blogapp.entities.BlogPostEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Nutty on 2016.08.08..
 */
@Repository
@Transactional(propagation = Propagation.SUPPORTS)
public class BlogPostDAOImpl extends BaseDaoImpl<BlogPostEntity, BlogPostDTO> implements BaseConvertDAO<BlogPostEntity, BlogPostDTO>, BlogPostDAO {
    @Override
    public BlogPostEntity toEntity(BlogPostDTO dto) {
        return dto.toEntity();
    }

    @Override
    public BlogPostDTO toDto(BlogPostEntity entity) {
        return entity.toDTO();
    }
}
