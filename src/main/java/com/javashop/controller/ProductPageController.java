package com.javashop.controller;

import com.javashop.DAO.CategoryDao;
import com.javashop.DAO.CategoryDaoimpl;
import com.javashop.DAO.ProductDao;
import com.javashop.DAO.ProductDaoImpl;
import com.javashop.model.ProductEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet("/catalog/product")
public class ProductPageController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.valueOf(request.getParameter("id"));
        ProductDao dao = new ProductDaoImpl();
        ProductEntity product = dao.getProductById(id);

        request.getServletContext().setAttribute("product",product);
        request.getRequestDispatcher("/WEB-INF/views/aboutProduct.jsp").forward(request,response);
    }
}
