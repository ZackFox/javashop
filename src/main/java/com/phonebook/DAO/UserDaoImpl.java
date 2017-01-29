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

    public List<UserProfile> getAllContacts() {
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

    public UserProfile getContactById(int id) {
        UserProfile contact = null;
        String sqlQuery = "select id,firstname,lastname,phone,email from contacts WHERE id=?";
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

    public void addContact(UserProfile contact) {
        String sqlQuery = "insert into contacts(firstname,lastname,address,phone,email) VALUES (?,?,?,?,?)";
        Connection connection = dbUtil.GetConnection();

        if(connection !=null){
            try {
                PreparedStatement ps = connection.prepareStatement(sqlQuery);

                ps.setString(1,contact.getFirstName());
                ps.setString(2,contact.getLastName());
                ps.setString(3,contact.getAddress());
                ps.setString(4,contact.getPhoneNumber());
                ps.setString(5,contact.getEmail());

                int ex = ps.executeUpdate();

                if (ex == 0){
                    throw new SQLException();
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
    }

    public void updateContact(UserProfile contact) {
        String sqlQuery = "UPDATE contacts set firstname=?,lastname=?,address=?,phone=?,email=? where id=?";
        Connection connection = dbUtil.GetConnection();

        if(connection !=null){
            try {
                PreparedStatement ps = connection.prepareStatement(sqlQuery);

                ps.setString(1,contact.getFirstName());
                ps.setString(2,contact.getLastName());
                ps.setString(3,contact.getAddress());
                ps.setString(4,contact.getPhoneNumber());
                ps.setString(5,contact.getEmail());
                ps.setInt(6,contact.getId());

                int ex = ps.executeUpdate();

                if (ex == 0){
                    throw new SQLException();
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
    }

    public void deleteContact(int id) {
        String sqlQuery = "DELETE FROM contacts WHERE id=?";
        Connection connection = dbUtil.GetConnection();

        if(connection !=null){
            try {
                PreparedStatement ps = connection.prepareStatement(sqlQuery);
                ps.setInt(1,id);

                int ex = ps.executeUpdate();

                if (ex == 0){
                    throw new SQLException();
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
    }
}
