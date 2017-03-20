package com.javashop.DAO;

import com.javashop.db.ConnectionPoolUtil;
import com.javashop.db.DbUtil;
import com.javashop.model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class CustomerDaoImpl implements CustomerDao {

    public List<Customer> getAllCustomers() {
        String sqlQuery = "select * from customers";

        List<Customer> customers = new LinkedList<>();

        Connection connection = DbUtil.getConnection();

        if(connection!=null){
            try {
                PreparedStatement ps = connection.prepareStatement(sqlQuery);
                ResultSet resultSet = ps.executeQuery();

                while(resultSet.next()){
                    Customer customer = new Customer();
                    customer.setId(resultSet.getInt("id"));
                    customer.setFirstName(resultSet.getString("firstname"));
                    customer.setLastName(resultSet.getString("lastname"));
                    customer.setAddress(resultSet.getString("address"));
                    customer.setPhoneNumber(resultSet.getString("phone"));
                    customer.setLogin(resultSet.getString("login"));
                    customer.setPassword(resultSet.getString("password"));
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

    public Customer getCustomerById(int id) {
        Customer customer = null;
        String sqlQuery = "select * from customers WHERE id=?";
        Connection connection = DbUtil.getConnection();

        if(connection!=null){
            try {
                PreparedStatement ps = connection.prepareStatement(sqlQuery);
                ps.setInt(1,id);
                ResultSet resultSet = ps.executeQuery();

                while(resultSet.next()){
                    customer = new Customer();
                    customer.setId(resultSet.getInt("id"));
                    customer.setFirstName(resultSet.getString("firstname"));
                    customer.setLastName(resultSet.getString("lastname"));
                    customer.setAddress(resultSet.getString("address"));
                    customer.setPhoneNumber(resultSet.getString("phone"));
                    customer.setLogin(resultSet.getString("login"));
                    customer.setPassword(resultSet.getString("password"));
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
    public Customer getCustomerByLogin(String login, String pass) {
        Customer customer = new Customer();
        String sqlQuery = "select * from customers WHERE login=? and password=?";
        Connection connection = DbUtil.getConnection();

        if(connection!=null){
            try {
                PreparedStatement ps = connection.prepareStatement(sqlQuery);
                ps.setString(1,login);
                ps.setString(2,pass);
                ResultSet resultSet = ps.executeQuery();

                while(resultSet.next()){
                    customer.setId(resultSet.getInt("id"));
                    customer.setFirstName(resultSet.getString("firstname"));
                    customer.setLastName(resultSet.getString("lastname"));
                    customer.setAddress(resultSet.getString("address"));
                    customer.setPhoneNumber(resultSet.getString("phone"));
                    customer.setLogin(resultSet.getString("login"));
                    customer.setPassword(resultSet.getString("password"));
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

    public void addCustomer(Customer customer) {
        String sqlQuery = "insert into customers(firstname,lastname,address,phone,login,password,email) VALUES (?,?,?,?,?,?,?)";
        Connection connection = ConnectionPoolUtil.getConnection();

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

    public void updateCustomer(Customer customer) {
        String sqlQuery = "UPDATE customers set firstname=?,lastname=?,address=?,phone=?,login=?,password=?,email=? where id=?";
        Connection connection = ConnectionPoolUtil.getConnection();

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
        String sqlQuery = "DELETE FROM customers WHERE id=?";
        Connection connection = ConnectionPoolUtil.getConnection();

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
