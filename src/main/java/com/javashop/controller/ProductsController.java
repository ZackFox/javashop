package com.javashop.controller;

import com.google.gson.Gson;
import com.javashop.DAO.ProductDao;
import com.javashop.DAO.ProductDaoImpl;
import com.javashop.model.ProductEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/catalog/category")
public class ProductsController extends HttpServlet {
    ProductDao dao = new ProductDaoImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cat_id = Integer.valueOf(request.getParameter("id"));

        List<ProductEntity> products = dao.getProductsByCategoryId(cat_id, 10,0);

        request.setAttribute("products",products);
        request.getRequestDispatcher("/WEB-INF/views/products.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int cat_id = Integer.valueOf(request.getParameter("catId"));
        int offset = Integer.valueOf(request.getParameter("shift"));

        List<ProductEntity> products = dao.getProductsByCategoryId(cat_id, 10, offset);
        String json = new Gson().toJson(products);

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }
}


