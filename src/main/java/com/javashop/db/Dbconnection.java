package com.javashop.db;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Dbconnection {

    private static Dbconnection pool = null;
    private static DataSource dataSource = null;

    private Dbconnection() {
        try {
            InitialContext ic = new InitialContext();
            Context envContext  = (Context)ic.lookup("java:/comp/env");
            dataSource = (DataSource)envContext.lookup("jdbc/heroku");
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
