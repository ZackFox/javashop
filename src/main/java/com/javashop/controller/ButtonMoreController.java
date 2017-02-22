//package com.javashop.controller;
//
//import com.javashop.DAO.ProductDao;
//import com.javashop.DAO.ProductDaoImpl;
//import com.javashop.model.ProductEntity;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.util.List;
//
//
//@WebServlet("/catalog/category")
//public class ButtonMoreController extends HttpServlet {
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        int cat_id = Integer.valueOf(request.getParameter("id"));
//        int lim = Integer.valueOf(request.getParameter("lim"));
//        int offset = Integer.valueOf(request.getParameter("offset"));
//
//        ProductDao dao = new ProductDaoImpl();
//        List<ProductEntity> products = dao.getProductsByCategoryId(cat_id,10,0);
//
//        request.setAttribute("products",products);
//        request.getRequestDispatcher("/WEB-INF/views/products.jsp").forward(request,response);
//    }
//}
