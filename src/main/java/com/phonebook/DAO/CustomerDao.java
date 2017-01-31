package com.phonebook.DAO;

import com.phonebook.domain.CustomerProfile;

import java.util.List;

public interface CustomerDao {
    List<CustomerProfile> getAllCustomers();
    CustomerProfile getCustomerById(int id);
    void addCustomer(CustomerProfile customer);
    void updateCustomer(CustomerProfile customer);
    void deleteCustomer(int id);
}
