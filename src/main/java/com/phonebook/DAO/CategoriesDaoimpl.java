package com.phonebook.DAO;

import com.phonebook.db.DBconnectionUtill;
import com.phonebook.model.CategoryEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriesDaoimpl implements CategoriesDao{

    private DBconnectionUtill dbUtill;

    public CategoriesDaoimpl() {
        dbUtill = new DBconnectionUtill();
    }

    @Override
    public List<CategoryEntity> getAllCategorie() {
        String sql= "select * from categories";
        List<CategoryEntity> list = new ArrayList<>();

        Connection connection= dbUtill.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                CategoryEntity category = new CategoryEntity();
                category.setId(rs.getInt("cat_id"));
                category.setName(rs.getString("cat_name"));
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

    @Override
    public void addCategory(CategoryEntity category) {

    }

    @Override
    public void deleteCategory(int id) {

    }
}
