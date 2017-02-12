package com.javashop.DAO;

import com.javashop.db.DBconnectionUtill;
import com.javashop.model.ProductEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao{

    private DBconnectionUtill dbUtill;

    public ProductDaoImpl() {
        dbUtill = new DBconnectionUtill();
    }

    @Override
    public List<ProductEntity> getProductsByCategoryId(int id) {
        String sql= "select * from products WHERE prod_cat=?";
        List<ProductEntity> list = new ArrayList<>();

        Connection connection= dbUtill.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                ProductEntity product = new ProductEntity();
                product.setId(rs.getInt("prod_id"));
                product.setName(rs.getString("prod_name"));
                product.setDescription(rs.getString("prod_desc"));
                product.setPrice(rs.getFloat("prod_price"));
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
        return null;
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
