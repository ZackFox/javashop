package com.phonebook.DAO;

import com.phonebook.domain.UserProfile;

import java.util.List;

public interface UserDao {
    List<UserProfile> getAllContacts();
    UserProfile getContactById(int id);
    void addContact(UserProfile contact);
    void updateContact(UserProfile contact);
    void deleteContact(int id);
}
