package com.phonebook.DAO;

import com.phonebook.db.DateBaseUtil;
import com.phonebook.domain.UserProfile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    private DateBaseUtil dbUtil;

    public UserDaoImpl(){
        dbUtil = new DateBaseUtil();
    }

    public List<UserProfile> getAllUsers() {
        String sqlQuery = "select id,firstname,lastname,phone,email from contacts";

        List<UserProfile> contacts = new LinkedList<>();

        Connection connection = dbUtil.GetConnection();

        if(connection!=null){
            try {
                PreparedStatement ps = connection.prepareStatement(sqlQuery);
                ResultSet resultSet = ps.executeQuery();

                while(resultSet.next()){
                    UserProfile contact = new UserProfile();
                    contact.setId(resultSet.getInt("id"));
                    contact.setFirstName(resultSet.getString("firstname"));
                    contact.setLastName(resultSet.getString("lastname"));
                    contact.setPhoneNumber(resultSet.getString("phone"));
                    contact.setEmail(resultSet.getString("email"));

                    contacts.add(contact);
                }
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return contacts;
    }

    public UserProfile getUserById(int id) {
        UserProfile contact = null;
        String sqlQuery = "select id,firstname,lastname,phone,email from contacts WHERE id=? ";
        Connection connection = dbUtil.GetConnection();

        if(connection!=null){
            try {
                PreparedStatement ps = connection.prepareStatement(sqlQuery);
                ps.setInt(1,id);
                ResultSet resultSet = ps.executeQuery();

                while(resultSet.next()){
                    contact = new UserProfile();
                    contact.setId(resultSet.getInt("id"));
                    contact.setFirstName(resultSet.getString("firstname"));
                    contact.setLastName(resultSet.getString("lastname"));
                    contact.setPhoneNumber(resultSet.getString("phone"));
                    contact.setEmail(resultSet.getString("email"));
                }
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return contact;
    }

    public void addUser(UserProfile user) {

    }

    public void updateUser(int id) {

    }

    public void deleteUser(int id) {

    }
}
