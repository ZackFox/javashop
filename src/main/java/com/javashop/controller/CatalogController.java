package com.javashop.controller;

import com.javashop.DAO.CategoryDao;
import com.javashop.DAO.CategoryDaoimpl;
import com.javashop.model.CategoryEntity;

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
