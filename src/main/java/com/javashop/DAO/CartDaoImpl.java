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
    public List<CartItem> getCartItems(String uuid) {
        String sql = "select product_id,products.title,products.price,quantity from cart_items JOIN products on product_id=products.id WHERE cart_uuid=?";
        List<CartItem> list = new ArrayList<>();

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try{
            connection = ConnectionPoolUtil.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setObject(1,UUID.fromString(uuid));
            resultSet = statement.executeQuery();

            while(resultSet.next()){
                CartItem item = new CartItem();
                item.setProductId(resultSet.getInt("product_id"));
                item.setTitle(resultSet.getString("title"));
                item.setProductPrice(resultSet.getInt("price"));
                item.setQuantity(resultSet.getInt("quantity"));
                list.add(item);
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
    }

    @Override
    public CartItem getCartItemById(String uuid, int product_id) {
        String sql = "select product_id,products.title,products.price,quantity from cart_items JOIN products on product_id=products.id WHERE cart_uuid=? AND product_id=?";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        CartItem item = new CartItem();

        try{
            connection = ConnectionPoolUtil.getConnection();
            statement = connection.prepareStatement(sql);
            statement.setObject(1,UUID.fromString(uuid));
            statement.setObject(2,product_id);
            resultSet = statement.executeQuery();

            while(resultSet.next()){
                item = new CartItem();
                item.setProductId(resultSet.getInt("product_id"));
                item.setTitle(resultSet.getString("title"));
                item.setProductPrice(resultSet.getInt("price"));
                item.setQuantity(resultSet.getInt("quantity"));
            }

        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return item;
    }

    @Override
    public void addToNewCart(String uuid,int product_id) {
        String query1 = "INSERT INTO carts (id) VALUES (?)";
        String query2= "INSERT INTO cart_items (cart_uuid,product_id) VALUES (?,?)";

        Connection connection= null;
        PreparedStatement statement1 = null;
        PreparedStatement statement2 = null;

        try{
            connection = ConnectionPoolUtil.getConnection();
            connection.setAutoCommit(false);

            statement1 = connection.prepareStatement(query1);
            statement1.setObject(1,UUID.fromString(uuid));
            statement1.executeUpdate();

            statement2 = connection.prepareStatement(query2);
            statement2.setObject(1,UUID.fromString(uuid));
            statement2.setInt(2,product_id);
            statement2.executeUpdate();

            connection.commit();
        }
        catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }

        }finally {
            try {
                statement1.close();
                statement2.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void addToCart(String uuid, int product_id) {
        String query1 = "insert into cart_items (cart_uuid,product_id) values (?,?)";
        String query2 = "UPDATE carts SET date_update = DEFAULT WHERE id = ?";

        Connection connection = null;
        PreparedStatement statement1 = null;
        PreparedStatement statement2 = null;

        try{
            connection = ConnectionPoolUtil.getConnection();
            connection.setAutoCommit(false);

            statement1 = connection.prepareStatement(query1);
            statement1.setObject(1,UUID.fromString(uuid));
            statement1.setInt(2,product_id);
            statement1.executeUpdate();

            statement2 = connection.prepareStatement(query2);
            statement2.setObject(1,UUID.fromString(uuid));
            statement2.executeUpdate();

            connection.commit();

        }catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            }
            catch (SQLException e1) {
                e1.printStackTrace();
            }
        }finally {
            try {
                statement1.close();
                statement2.close();
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void increaseQuantity(String uuid, int product_id) {
        String query1 = "UPDATE cart_items SET quantity = cart_items.quantity+1 WHERE cart_uuid=? and product_id=?";
        String query2 = "UPDATE carts SET date_update = DEFAULT WHERE id = ?";

        Connection connection = null;
        PreparedStatement statement1 = null;
        PreparedStatement statement2 = null;

        try{
            connection = ConnectionPoolUtil.getConnection();
            connection.setAutoCommit(false);

            statement1 = connection.prepareStatement(query1);
            statement1.setObject(1,UUID.fromString(uuid));
            statement1.setInt(2,product_id);
            statement1.executeUpdate();

            statement2 = connection.prepareStatement(query2);
            statement2.setObject(1,UUID.fromString(uuid));
            statement2.executeUpdate();

            connection.commit();

        }catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            }
            catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        finally {
            try {
                statement1.close();
                statement2.close();
                connection.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void decreaseQuantity(int i, String uuid, int product_id) {
        String query1 = "UPDATE cart_items SET quantity = cart_items.quantity+? WHERE cart_uuid=? and product_id=?";
        String query2 = "UPDATE carts SET date_update = DEFAULT WHERE id = ?";

        Connection connection = null;
        PreparedStatement statement1 = null;
        PreparedStatement statement2 = null;

        try{
            connection = ConnectionPoolUtil.getConnection();
            connection.setAutoCommit(false);

            statement1 = connection.prepareStatement(query1);
            statement1.setObject(1,i);
            statement1.setObject(2,UUID.fromString(uuid));
            statement1.setInt(3,product_id);
            statement1.executeUpdate();

            statement2 = connection.prepareStatement(query2);
            statement2.setObject(1,UUID.fromString(uuid));
            statement2.executeUpdate();

            connection.commit();

        }catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            }
            catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        finally {
            try {
                statement1.close();
                statement2.close();
                connection.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void deleteItem(String uuid, int product_id) {
        String query1 = "DELETE FROM cart_items WHERE cart_uuid=? and product_id=?";
        String query2 = "UPDATE carts SET date_update = DEFAULT WHERE id = ?";

        Connection connection = null;
        PreparedStatement statement1 = null;
        PreparedStatement statement2 = null;

        try{
            connection = ConnectionPoolUtil.getConnection();
            connection.setAutoCommit(false);

            statement1 = connection.prepareStatement(query1);
            statement1.setObject(1,UUID.fromString(uuid));
            statement1.setInt(2,product_id);
            statement1.executeUpdate();

            statement2 = connection.prepareStatement(query2);
            statement2.setObject(1,UUID.fromString(uuid));
            statement2.executeUpdate();

            connection.commit();

        }catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            }
            catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
        finally {
            try {
                statement1.close();
                statement2.close();
                connection.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void DeleteCart(String uuid) {
        String query = "DELETE from carts WHERE id=?";

        Connection connection = null;
        PreparedStatement statement = null;

        try{
            connection = ConnectionPoolUtil.getConnection();
            statement = connection.prepareStatement(query);
            statement.setObject(1,UUID.fromString(uuid));
            statement.executeUpdate();

        }catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                statement.close();
                connection.close();
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
