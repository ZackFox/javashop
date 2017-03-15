package com.javashop.DAO;

import com.javashop.db.ConnectionPoolUtil;
import com.javashop.model.BrandEntity;
import com.javashop.model.ProductEntity;
import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao{

    @Override
    public List<ProductEntity> getProductsByCategoryId(int id,int limit,int offset) {
        String sql= "select * from products WHERE category_id=? LIMIT "+limit+" OFFSET "+offset;
        List<ProductEntity> list = new ArrayList<>();

        Connection connection = ConnectionPoolUtil.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                ProductEntity product = new ProductEntity();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("title"));
                product.setDescription(rs.getString("description"));
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
    public List<ProductEntity> getFilteredProductsByCategoryId(int brandId, int catId, int limit, int offset) {
        String sql= "select * from products WHERE category_id=? AND brand=? LIMIT "+limit+" OFFSET "+offset;
        List<ProductEntity> list = new ArrayList<>();

        Connection connection = ConnectionPoolUtil.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,catId);
            ps.setInt(2,brandId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                ProductEntity product = new ProductEntity();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("title"));
                product.setDescription(rs.getString("description"));
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
    public List<BrandEntity> getBrandsByCategoryId(int id) {
        List<BrandEntity> list = new ArrayList<>();
        String sql ="SELECT DISTINCT brands.id, brands.name FROM brands INNER JOIN products ON products.brand = brands.id WHERE products.category_id=?";
        Connection con = null;


        try {
            con = ConnectionPoolUtil.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                BrandEntity brand= new BrandEntity();
                brand.setId(rs.getInt("id"));
                brand.setName(rs.getString("name"));
                list.add(brand);
            }
            rs.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                con.close();
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

        Connection connection = ConnectionPoolUtil.getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet resultSet = ps.executeQuery();

            while (resultSet.next()){
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("title"));
                product.setDescription(resultSet.getString("description"));
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
