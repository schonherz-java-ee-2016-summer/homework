package hu.nutty.kepzes.blogapp.dao.implementations;

import hu.nutty.kepzes.blogapp.dao.BaseConvertDAO;
import hu.nutty.kepzes.blogapp.dao.BloggerDAO;
import hu.nutty.kepzes.blogapp.dto.BloggerDTO;
import hu.nutty.kepzes.blogapp.entities.BloggerEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Nutty on 2016.08.08..
 */
@Repository
@Transactional(propagation = Propagation.SUPPORTS)
public class BloggerDAOImpl extends BaseDaoImpl<BloggerEntity, BloggerDTO> implements BaseConvertDAO<BloggerEntity, BloggerDTO>, BloggerDAO {
    @Override
    public BloggerEntity toEntity(BloggerDTO dto) {
        return dto.toEntity();
    }

    @Override
    public BloggerDTO toDto(BloggerEntity entity) {
        return entity.toDTO();
    }
}
