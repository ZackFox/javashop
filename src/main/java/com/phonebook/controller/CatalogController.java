package com.phonebook.controller;

import com.phonebook.DAO.CategoryDao;
import com.phonebook.DAO.CategoryDaoimpl;
import com.phonebook.model.CategoryEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/catalog")
public class CatalogController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // вывод списка категорий и товаровЛ
        CategoryDao dao = new CategoryDaoimpl();
        List<CategoryEntity> categories = dao.getAllCategorie();

        request.getServletContext().setAttribute("categories",categories);
        request.getRequestDispatcher("/WEB-INF/views/catalog.jsp").forward(request,response);
    }
}
