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
        String sqlQuery = "select * from customers";

        List<CustomerProfile> customers = new LinkedList<>();

        Connection connection = dbUtil.GetConnection();

        if(connection!=null){
            try {
                PreparedStatement ps = connection.prepareStatement(sqlQuery);
                ResultSet resultSet = ps.executeQuery();

                while(resultSet.next()){
                    CustomerProfile customer = new CustomerProfile();
                    customer.setId(resultSet.getInt("customer_id"));
                    customer.setFirstName(resultSet.getString("firstname"));
                    customer.setLastName(resultSet.getString("lastname"));
                    customer.setAddress(resultSet.getString("address"));
                    customer.setPhoneNumber(resultSet.getString("phone"));
                    customer.setLogin(resultSet.getString("customer_login"));
                    customer.setPassword(resultSet.getString("customer_password"));
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
        String sqlQuery = "select * from customers WHERE customer_id=?";
        Connection connection = dbUtil.GetConnection();

        if(connection!=null){
            try {
                PreparedStatement ps = connection.prepareStatement(sqlQuery);
                ps.setInt(1,id);
                ResultSet resultSet = ps.executeQuery();

                while(resultSet.next()){
                    customer = new CustomerProfile();
                    customer.setId(resultSet.getInt("customer_id"));
                    customer.setFirstName(resultSet.getString("firstname"));
                    customer.setLastName(resultSet.getString("lastname"));
                    customer.setAddress(resultSet.getString("address"));
                    customer.setPhoneNumber(resultSet.getString("phone"));
                    customer.setLogin(resultSet.getString("customer_login"));
                    customer.setPassword(resultSet.getString("customer_password"));
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

    @Override
    public CustomerProfile getCustomerByLogin(String login, String pass) {
        CustomerProfile customer = new CustomerProfile();
        String sqlQuery = "select * from customers WHERE customer_login=? and customer_password=?";
        Connection connection = dbUtil.GetConnection();

        if(connection!=null){
            try {
                PreparedStatement ps = connection.prepareStatement(sqlQuery);
                ps.setString(1,login);
                ps.setString(2,pass);
                ResultSet resultSet = ps.executeQuery();

                while(resultSet.next()){
                    customer.setId(resultSet.getInt("customer_id"));
                    customer.setFirstName(resultSet.getString("firstname"));
                    customer.setLastName(resultSet.getString("lastname"));
                    customer.setAddress(resultSet.getString("address"));
                    customer.setPhoneNumber(resultSet.getString("phone"));
                    customer.setLogin(resultSet.getString("customer_login"));
                    customer.setPassword(resultSet.getString("customer_password"));
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
        String sqlQuery = "insert into customers(firstname,lastname,address,phone,customer_login,customer_password,email) VALUES (?,?,?,?,?,?,?)";
        Connection connection = dbUtil.GetConnection();

        if(connection !=null){
            try {
                PreparedStatement ps = connection.prepareStatement(sqlQuery);

                ps.setString(1,customer.getFirstName());
                ps.setString(2,customer.getLastName());
                ps.setString(3,customer.getAddress());
                ps.setString(4,customer.getPhoneNumber());
                ps.setString(5,customer.getLogin());
                ps.setString(6,customer.getPassword());
                ps.setString(7,customer.getEmail());

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
        String sqlQuery = "UPDATE customers set firstname=?,lastname=?,address=?,phone=?,customer_login=?,customer_password=?,email=? where customer_id=?";
        Connection connection = dbUtil.GetConnection();

        if(connection !=null){
            try {
                PreparedStatement ps = connection.prepareStatement(sqlQuery);

                ps.setString(1,customer.getFirstName());
                ps.setString(2,customer.getLastName());
                ps.setString(3,customer.getAddress());
                ps.setString(4,customer.getPhoneNumber());
                ps.setString(5,customer.getLogin());
                ps.setString(6,customer.getPassword());
                ps.setString(7,customer.getEmail());
                ps.setInt(8,customer.getId());

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
        String sqlQuery = "DELETE FROM customers WHERE customer_id=?";
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