package com.javashop.DAO;

import com.javashop.db.DbUtil;
import com.javashop.model.ProductEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao{

    @Override
    public List<ProductEntity> getProductsByCategoryId(int id) {
        String sql= "select * from products WHERE cat_id=?";
        List<ProductEntity> list = new ArrayList<>();

        Connection connection = DbUtil.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                ProductEntity product = new ProductEntity();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setDescription(rs.getString("desc"));
                product.setPrice(rs.getFloat("price"));
                list.add(product);
            }
            ps.close();

        }catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    @Override
    public ProductEntity getProductById(int id) {

        String sql = "select * from products where id=?";
        ProductEntity product = new ProductEntity();

        Connection connection = DbUtil.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()){
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("name"));
                product.setDescription(resultSet.getString("desc"));
                product.setPrice(resultSet.getFloat("price"));
            }

            ps.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return product;
    }

//    @Override
//    public void addCategory(CategoryEntity category) {
//
//    }
//
//    @Override
//    public void deleteCategory(int id) {
//
//    }
}
