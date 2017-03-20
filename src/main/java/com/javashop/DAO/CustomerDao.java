package com.javashop.DAO;

import com.javashop.model.Customer;
import java.util.List;

public interface CustomerDao {
    List<Customer> getAllCustomers();
    Customer getCustomerById(int id);
    Customer getCustomerByLogin(String login, String pass);
    void addCustomer(Customer customer);
    void updateCustomer(Customer customer);
    void deleteCustomer(int id);
}
