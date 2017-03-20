package com.javashop.DAO;

import com.javashop.db.ConnectionPoolUtil;
import com.javashop.model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoimpl implements CategoryDao {

    @Override
    public List<Category> getAllCategories() {

        String sql= "select * from categories ORDER BY id";
        List<Category> list = new ArrayList<>();
        Connection connection = null;

        try {
            connection = ConnectionPoolUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                category.setParentId(rs.getInt("parent_id"));
                list.add(category);
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

    public void addCategory(Category category) {

    }

    @Override
    public void deleteCategory(int id) {

    }
}
