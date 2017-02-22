package com.javashop.DAO;

import com.javashop.model.ProductEntity;

import java.util.List;

public interface ProductDao {
    List<ProductEntity> getProductsByCategoryId(int id,int limit,int offset);
    ProductEntity getProductById(int id);
}
