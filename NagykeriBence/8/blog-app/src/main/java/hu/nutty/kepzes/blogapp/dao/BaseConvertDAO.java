package hu.nutty.kepzes.blogapp.dao;

import hu.nutty.kepzes.blogapp.entities.BaseEntity;

import java.io.Serializable;
import java.util.List;

public interface BaseConvertDAO<E extends BaseEntity, D extends Serializable> {

    E toEntity(D dto);

    D toDto(E entity);

    Long saveEntity(E entity) throws Exception;

    void updateEntity(E entity) throws Exception;

    void deleteEntity(Long id) throws Exception;

    E findEntity(Long id) throws Exception;

    List<E> findAllEntity() throws Exception;
}
