package com.phonebook.DAO;

import com.phonebook.model.ProductEntity;

import java.util.List;

public interface ProductDao {
    List<ProductEntity> getProductsByCategoryId(int id);
    ProductEntity getProductById(int id);
}
