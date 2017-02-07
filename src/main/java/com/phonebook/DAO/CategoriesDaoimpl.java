package com.phonebook.DAO;

import com.phonebook.db.DBconnectionUtill;

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
    public List<String> getAllCategorie() {
        String sql= "select * from categories";
        List<String> list = new ArrayList<>();

        Connection connection= dbUtill.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                list.add(rs.getString("cat_name"));
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
    public void addCategory(String name) {

    }

    @Override
    public void deleteCategory(int id) {

    }
}
