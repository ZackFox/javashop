package com.javashop.DAO;

import com.javashop.db.ConnectionPoolUtil;
import com.javashop.model.CategoryEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoimpl implements CategoryDao {

    @Override
    public List<CategoryEntity> getAllCategories() {

        String sql= "select * from categories ORDER BY id";
        List<CategoryEntity> list = new ArrayList<>();
        Connection connection = null;

        try {
            connection = ConnectionPoolUtil.getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                CategoryEntity category = new CategoryEntity();
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

        return CategoryEntity.splitCategories(list);
    }

    public void addCategory(CategoryEntity category) {

    }

    @Override
    public void deleteCategory(int id) {

    }
}
