package com.javashop.DAO;

import com.javashop.model.CartItem;

import java.util.List;

public interface CartDao {
    void addToNewCart(String uuid,int product_id);
    List<CartItem> getCartItems(String uuid);
    void addToCart(String uuid, int product_id);
    void increaseQuantity(String uuid, int product_id);
    void decreaseQuantity(String uuid, int product_id);
    void deleteProduct(String uuid, int product_id);
    void DeleteCart(String uuid);
}
