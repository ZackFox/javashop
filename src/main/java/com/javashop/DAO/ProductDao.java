package com.javashop.DAO;

import com.javashop.model.ProductEntity;

import java.util.List;

public interface ProductDao {
    List<ProductEntity> getProductsByCategoryId(int id);
    ProductEntity getProductById(int id);
}
