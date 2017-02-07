package com.phonebook.DAO;

import com.phonebook.model.CustomerProfile;
import java.util.List;

public interface CustomerDao {
    List<CustomerProfile> getAllCustomers();
    CustomerProfile getCustomerById(int id);
    CustomerProfile getCustomerByLogin(String login,String pass);
    void addCustomer(CustomerProfile customer);
    void updateCustomer(CustomerProfile customer);
    void deleteCustomer(int id);
}
