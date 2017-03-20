package com.javashop.DAO;

import com.javashop.model.Category;

import java.util.List;

public interface CategoryDao {
    List<Category> getAllCategories();
    void addCategory(Category category);
    void deleteCategory(int id);
}
