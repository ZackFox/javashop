package com.javashop.db;

import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Dbconnection {

    private static Dbconnection pool = null;
    private static DataSource dataSource = null;

    private Dbconnection() {
        try {
            InitialContext ctx = new InitialContext();
            dataSource = (DataSource)ctx.lookup("java:/comp/env/jdbc/heroku");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static Dbconnection getInstance() {
        if (pool == null) pool = new Dbconnection();
        return pool;
    }

    public static Connection getConnection() {
        try {
            return dataSource.getConnection();
        }catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        }
    }
}
