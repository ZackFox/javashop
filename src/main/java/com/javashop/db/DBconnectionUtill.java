package com.javashop.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnectionUtill {

    public DBconnectionUtill() {
    }

    public Connection getConnection(){
        Connection connection = null;

        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://ec2-107-20-149-243.compute-1.amazonaws.com:5432/d7gloj3v6puv1q?user=dqgbtpzuiwhuwt&password=3a9d7a669cbcbfbad2ec543e5d05190d7d36499a94bb9d05450f537b5cad322f&ssl=true&sslfactory=org.postgresql.ssl.NonValidatingFactory");
        } catch (SQLException |ClassNotFoundException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
