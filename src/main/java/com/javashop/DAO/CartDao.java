package com.javashop.DAO;

import com.javashop.model.CartItem;

import java.util.List;

public interface CartDao {
    List<CartItem> getCartItems(String uuid);
    CartItem getCartItemById(String uuid,int product_id);
    void addToNewCart(String uuid,int product_id);
    void addToCart(String uuid, int product_id);
    void increaseQuantity(String uuid, int product_id);
    void decreaseQuantity(int i,String uuid, int product_id);
    void deleteItem(String uuid, int product_id);
    void DeleteCart(String uuid);
}
