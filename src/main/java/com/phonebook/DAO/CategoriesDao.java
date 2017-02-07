package com.phonebook.DAO;

import java.util.List;

public interface CategoriesDao {
    List<String> getAllCategorie();
    void addCategory(String name);
    void deleteCategory(int id);
}
