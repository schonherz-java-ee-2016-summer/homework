package hu.training.homework.simpleblog.dao;


import hu.training.homework.simpleblog.dao.impl.JDBCTemplatePostDAOImpl;

import javax.sql.DataSource;

public class PostDAOFactory {

    public static PostDAO getPostDAO(DataSource dataSource) {
        return new JDBCTemplatePostDAOImpl(dataSource);
    }

}
