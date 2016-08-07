package hu.nutty.kepzes.blogapp.dao;

import java.util.List;

public interface BaseDAO<T> {

    Long save(T dto) throws Exception;

    void update(T dto) throws Exception;

    void delete(Long id) throws Exception;

    T find(Long id) throws Exception;

    List<T> findAll() throws Exception;
}