package com.javashop.DAO;

import com.javashop.db.ConnectionPoolUtil;
import com.javashop.model.Brand;
import com.javashop.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao{

    @Override
    public List<Product> getProductsByCategoryId(int catId, int brandId, int limit, int offset) {
        String sql = "";//REVU когда if/else - не надо инициализировать.
        //REVU можно вынести в 2 константы.
        //REVU почему бы не модставлять limit/offset через ? ?
        if (brandId != 0){
            sql = "select * from products WHERE category_id=? AND brand=? LIMIT "+limit+" OFFSET "+offset;
        }else{
            sql = "select * from products WHERE category_id=? LIMIT "+limit+" OFFSET "+offset;
        }




        List<Product> list = new ArrayList<>();

        Connection connection = ConnectionPoolUtil.getConnection();
        try {

            PreparedStatement ps = connection.prepareStatement(sql);//REVU кто закроет в случае ошибки?
            ps.setInt(1, catId);

            if (brandId != 0) ps.setInt(2, brandId);
            ResultSet rs = ps.executeQuery();//REVU кто закроет в случае ошибки?

            while (rs.next()){
                Product product = new Product();
                product.setId(rs.getInt("id"));
                product.setName(rs.getString("title"));
                product.setDescription(rs.getString("description"));
                product.setPrice(rs.getInt("price"));
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
    public List<Brand> getBrandsByCategoryId(int id) {
        List<Brand> list = new ArrayList<>();
        String sql ="SELECT DISTINCT brands.id, brands.name FROM brands INNER JOIN products ON products.brand = brands.id WHERE products.category_id=?";
        Connection con = null;


        try {
            con = ConnectionPoolUtil.getConnection();
            //REVU con == null?
            PreparedStatement ps = con.prepareStatement(sql);//REVU кто закроет?
            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Brand brand= new Brand();
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
                con.close();//REVU NPE?
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return list;
    }

    @Override
    public Product getProductById(int id) {

        String sql = "select * from products where id=?";
        Product product = new Product();

        Connection connection = ConnectionPoolUtil.getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement(sql);//REVU кто закроет в случае ошибки?
            ps.setInt(1,id);
            ResultSet resultSet = ps.executeQuery();//REVU кто закроет в случае ошибки?

            while (resultSet.next()){
                product.setId(resultSet.getInt("id"));
                product.setName(resultSet.getString("title"));
                product.setDescription(resultSet.getString("description"));
                product.setPrice(resultSet.getInt("price"));
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

    //REVU что это такое?
//    @Override
//    public void addCategory(Category category) {
//
//    }
//
//    @Override
//    public void deleteCategory(int id) {
//
//    }
}
