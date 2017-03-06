package com.javashop.DAO;

import com.javashop.model.CategoryEntity;

import java.util.List;

public interface CategoryDao {
    List<CategoryEntity> getAllCategories();
    void addCategory(CategoryEntity category);
    void deleteCategory(int id);
}
