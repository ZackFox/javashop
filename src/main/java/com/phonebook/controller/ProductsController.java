package com.phonebook.controller;

import com.phonebook.DAO.CategoriesDao;
import com.phonebook.DAO.CategoriesDaoimpl;
import com.phonebook.DAO.CustomerDao;
import com.phonebook.DAO.CustomerDaoImpl;
import com.phonebook.model.CustomerProfile;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/products")
public class ProductsController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // вывод списка категорий и товаровЛ
        CategoriesDao dao = new CategoriesDaoimpl();
        List<String> categories = dao.getAllCategorie();

        request.setAttribute("categories",categories);
        request.getRequestDispatcher("/WEB-INF/views/products.jsp").forward(request,response);
    }
}
