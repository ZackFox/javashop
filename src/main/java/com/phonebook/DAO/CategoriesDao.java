package com.phonebook.DAO;

import com.phonebook.model.CategoryEntity;

import java.util.List;

public interface CategoriesDao {
    List<CategoryEntity> getAllCategorie();
    void addCategory(CategoryEntity category);
    void deleteCategory(int id);
}
