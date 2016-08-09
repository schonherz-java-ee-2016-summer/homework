package hu.nutty.kepzes.blogapp.dao.implementations;

import hu.nutty.kepzes.blogapp.dao.BaseConvertDAO;
import hu.nutty.kepzes.blogapp.dao.CommentDAO;
import hu.nutty.kepzes.blogapp.dto.CommentDTO;
import hu.nutty.kepzes.blogapp.entities.CommentEntity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nutty on 2016.08.08..
 */
@Repository
@Transactional(propagation = Propagation.SUPPORTS)
public class CommentDAOImpl extends BaseDaoImpl<CommentEntity, CommentDTO> implements BaseConvertDAO<CommentEntity, CommentDTO>, CommentDAO {

    @Override
    public CommentEntity toEntity(CommentDTO dto) {
        return dto.toEntity();
    }

    @Override
    public CommentDTO toDto(CommentEntity entity) {
        return entity.toDTO();
    }

}
