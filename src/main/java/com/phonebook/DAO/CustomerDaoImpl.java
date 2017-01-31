package com.phonebook.DAO;

import com.phonebook.db.DateBaseUtil;
import com.phonebook.domain.CustomerProfile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {

    private DateBaseUtil dbUtil;

    public CustomerDaoImpl(){
        dbUtil = new DateBaseUtil();
    }

    public List<CustomerProfile> getAllCustomers() {
        String sqlQuery = "select id,firstname,lastname,phone,email from customers";

        List<CustomerProfile> customers = new LinkedList<>();

        Connection connection = dbUtil.GetConnection();

        if(connection!=null){
            try {
                PreparedStatement ps = connection.prepareStatement(sqlQuery);
                ResultSet resultSet = ps.executeQuery();

                while(resultSet.next()){
                    CustomerProfile customer = new CustomerProfile();
                    customer.setId(resultSet.getInt("id"));
                    customer.setFirstName(resultSet.getString("firstname"));
                    customer.setLastName(resultSet.getString("lastname"));
                    customer.setPhoneNumber(resultSet.getString("phone"));
                    customer.setEmail(resultSet.getString("email"));

                    customers.add(customer);
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

        return customers;
    }

    public CustomerProfile getCustomerById(int id) {
        CustomerProfile customer = null;
        String sqlQuery = "select id,firstname,lastname,phone,email from customers WHERE id=?";
        Connection connection = dbUtil.GetConnection();

        if(connection!=null){
            try {
                PreparedStatement ps = connection.prepareStatement(sqlQuery);
                ps.setInt(1,id);
                ResultSet resultSet = ps.executeQuery();

                while(resultSet.next()){
                    customer = new CustomerProfile();
                    customer.setId(resultSet.getInt("id"));
                    customer.setFirstName(resultSet.getString("firstname"));
                    customer.setLastName(resultSet.getString("lastname"));
                    customer.setPhoneNumber(resultSet.getString("phone"));
                    customer.setEmail(resultSet.getString("email"));
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

        return customer;
    }

    public void addCustomer(CustomerProfile customer) {
        String sqlQuery = "insert into customers(firstname,lastname,address,phone,email) VALUES (?,?,?,?,?)";
        Connection connection = dbUtil.GetConnection();

        if(connection !=null){
            try {
                PreparedStatement ps = connection.prepareStatement(sqlQuery);

                ps.setString(1,customer.getFirstName());
                ps.setString(2,customer.getLastName());
                ps.setString(3,customer.getAddress());
                ps.setString(4,customer.getPhoneNumber());
                ps.setString(5,customer.getEmail());

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

    public void updateCustomer(CustomerProfile customer) {
        String sqlQuery = "UPDATE customers set firstname=?,lastname=?,address=?,phone=?,email=? where id=?";
        Connection connection = dbUtil.GetConnection();

        if(connection !=null){
            try {
                PreparedStatement ps = connection.prepareStatement(sqlQuery);

                ps.setString(1,customer.getFirstName());
                ps.setString(2,customer.getLastName());
                ps.setString(3,customer.getAddress());
                ps.setString(4,customer.getPhoneNumber());
                ps.setString(5,customer.getEmail());
                ps.setInt(6,customer.getId());

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

    public void deleteCustomer(int id) {
        String sqlQuery = "DELETE FROM customers WHERE id=?";
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
