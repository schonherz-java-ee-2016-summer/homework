package hu.schonherz.java.training.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Home on 2016. 07. 28..
 */
public class PostgreSQLConnection {

    public static Connection getConnection() throws SQLException {

        Connection conn = null;

        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Blog", "postgres", "pass");
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
