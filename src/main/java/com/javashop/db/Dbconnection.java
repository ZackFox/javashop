package com.javashop.db;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Dbconnection {

    private static InitialContext ic;
    private static DataSource ds;

    public static Connection getConnection() throws SQLException, NamingException {
        ic = new InitialContext();
        ds = (DataSource) ic.lookup("java:/comp/env/jdbc/heroku");
        return ds.getConnection();
    }
}
