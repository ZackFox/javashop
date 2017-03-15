package com.javashop.DAO;

import com.javashop.model.Brand;
import com.javashop.model.ProductEntity;

import java.util.List;

public interface ProductDao {
    List<ProductEntity> getProductsByCategoryId(int id,int limit,int offset);
    List<ProductEntity> getFilteredProductsByCategoryId(int brandId, int catId, int limit, int offset);
    List<Brand> getBrandsByCategoryId(int id);
    ProductEntity getProductById(int id);
}
