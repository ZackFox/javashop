package com.phonebook.DAO;

import com.phonebook.db.DateBaseUtil;
import com.phonebook.domain.UserProfile;

import java.util.List;

public class UserDaoImpl implements UserDao {

    private DateBaseUtil dbUtil;

    UserDaoImpl(){
        dbUtil = new DateBaseUtil();
    }

    public List<UserProfile> getAllUsers() {
        return null;
    }

    public UserProfile getUserById(int id) {
        return null;
    }

    public void addUser(UserProfile user) {

    }

    public void updateUser(int id) {

    }

    public void deleteUser(int id) {

    }
}
