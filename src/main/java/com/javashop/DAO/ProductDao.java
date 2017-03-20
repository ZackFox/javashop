package com.javashop.DAO;

import com.javashop.model.Brand;
import com.javashop.model.Product;

import java.util.List;

public interface ProductDao {
    List<Product> getProductsByCategoryId(int catId, int brandId, int limit, int offset);
    List<Brand> getBrandsByCategoryId(int id);
    Product getProductById(int id);
}
