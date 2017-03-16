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


@WebServlet("/get/products")
public class ProductsJsonController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int catId = Integer.valueOf(request.getParameter("catId"));
        int brandId = Integer.valueOf(request.getParameter("brandId"));
        int offset = Integer.valueOf(request.getParameter("offset"));
        int limit = Integer.valueOf(request.getParameter("limit"));

        ProductDao dao = new ProductDaoImpl();
        List<ProductEntity> products = null;

        if(brandId != 0){
            products = dao.getFilteredProductsByCategoryId(brandId,catId,limit,offset);
        }else{
            products = dao.getProductsByCategoryId(catId,limit,offset);
        }

        String json = new Gson().toJson(products);
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
