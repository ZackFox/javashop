package com.phonebook.DAO;

import com.phonebook.domain.UserProfile;

import java.util.List;

public interface UserDao {
    List<UserProfile> getAllUsers();
    UserProfile getUserById(int id);
    void addUser (UserProfile user);
    void updateUser (int id);
    void deleteUser (int id);
}
