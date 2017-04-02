package com.javashop.DAO;

import com.javashop.db.ConnectionPoolUtil;
import com.javashop.model.CartItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CartDaoImpl implements CartDao {

    @Override
    public void addToNewCart(String uuid,int product_id) {
        String insert1 = "INSERT INTO carts (id) VALUES (?)";
        String insert2= "INSERT INTO cart_items (cart_uuid,product_id) VALUES (?,?)";

        Connection con= null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;

        try{
            con = ConnectionPoolUtil.getConnection();
            con.setAutoCommit(false);

            ps1 = con.prepareStatement(insert1);
            ps1.setObject(1,UUID.fromString(uuid));
            ps1.execute();

            ps2 = con.prepareStatement(insert2);
            ps2.setObject(1,UUID.fromString(uuid));
            ps2.setInt(2,product_id);
            ps2.executeUpdate();

            con.commit();
        }
        catch (SQLException e) {
            e.printStackTrace();
            try {
                con.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        }finally {
            try {
                ps1.close();
                ps2.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public List<CartItem> getCartItems(String uuid) {
        String sql = "select product_id,products.title,products.price,quantity from cart_items JOIN products on product_id=products.id WHERE cart_uuid=?";
        List<CartItem> list = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try{
            con = ConnectionPoolUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1,UUID.fromString(uuid));
            rs = ps.executeQuery();

            while(rs.next()){
                CartItem item = new CartItem();
                item.setProductId(rs.getInt("product_id"));
                item.setTitle(rs.getString("title"));
                item.setProductPrice(rs.getInt("price"));
                item.setQuantity(rs.getInt("quantity"));
                list.add(item);
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
    }

    @Override
    public CartItem getCartItemById(String uuid, int product_id) {
        String sql = "select product_id,products.title,products.price,quantity from cart_items JOIN products on product_id=products.id WHERE cart_uuid=? AND product_id=?";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        CartItem item = new CartItem();

        try{
            con = ConnectionPoolUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1,UUID.fromString(uuid));
            ps.setObject(2,product_id);
            rs = ps.executeQuery();

            while(rs.next()){
                item = new CartItem();
                item.setProductId(rs.getInt("product_id"));
                item.setTitle(rs.getString("title"));
                item.setProductPrice(rs.getInt("price"));
                item.setQuantity(rs.getInt("quantity"));
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                rs.close();
                ps.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return item;
    }

    @Override
    public void addToCart(String uuid, int product_id) {
        String sql = "insert into cart_items (cart_uuid,product_id) values (?,?)";
        Connection con = null;
        PreparedStatement ps = null;

        try{
            con = ConnectionPoolUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1,UUID.fromString(uuid));
            ps.setInt(2,product_id);
            ps.executeUpdate();

        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void increaseQuantity(String uuid, int product_id) {
        String sql = "UPDATE cart_items SET quantity = cart_items.quantity+1 WHERE cart_uuid=? and product_id=?";
        Connection con = null;
        PreparedStatement ps = null;

        try{
            con = ConnectionPoolUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setObject(1,UUID.fromString(uuid));
            ps.setInt(2,product_id);
            ps.executeUpdate();

        }catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                ps.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void decreaseQuantity(String uuid, int product_id) {

    }

    @Override
    public void deleteItem(String uuid, int product_id) {

    }

    @Override
    public void DeleteCart(String uuid) {

    }
}
