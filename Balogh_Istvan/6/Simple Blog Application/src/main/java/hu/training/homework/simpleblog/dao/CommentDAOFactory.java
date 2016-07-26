package hu.training.homework.simpleblog.dao;

import hu.training.homework.simpleblog.dao.impl.JDBCTemplateCommentDAOImpl;

import javax.sql.DataSource;

public class CommentDAOFactory {

    public static CommentDAO getCommentDAO(DataSource dataSource) {
        return new JDBCTemplateCommentDAOImpl(dataSource);
    }

}
