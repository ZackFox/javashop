package com.javashop.db;

import org.apache.commons.dbcp2.BasicDataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Dbconnection {

    private static Dbconnection instance = null;
    private static BasicDataSource connectionPool = null;

    static {
        connectionPool = new BasicDataSource();
        connectionPool.setDriverClassName("org.postgresql.Driver");
        connectionPool.setUrl("jdbc:postgresql://ec2-107-20-149-243.compute-1.amazonaws.com:5432/d7gloj3v6puv1q?user=dqgbtpzuiwhuwt&password=3a9d7a669cbcbfbad2ec543e5d05190d7d36499a94bb9d05450f537b5cad322f&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory");
        connectionPool.setInitialSize(1);
        connectionPool.setMaxTotal(1);
    }

    public static Connection getConnection() {
        try {
            return connectionPool.getConnection();
        }catch (SQLException sqle) {
            sqle.printStackTrace();
            return null;
        }
    }
}
