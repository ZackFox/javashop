package com.phonebook.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnectionUtill {
    private String dbName;

    public DBconnectionUtill() {
        this.dbName = "mydb";
    }

    public DBconnectionUtill(String dbName) {
        this.dbName = dbName;
    }

    public Connection getConnection(){
        Connection connection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","root");
        } catch (SQLException| ClassNotFoundException| InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
