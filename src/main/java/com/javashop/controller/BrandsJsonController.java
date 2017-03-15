package com.javashop.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/get/brand")
public class BrandsJsonController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        ProductDao dao = new ProductDaoImpl();
//        int catId = Integer.valueOf(request.getParameter("catId"));
//
//        List<Brand> brands = dao.getBrandsByCategoryId(catId);
//        String json = new Gson().toJson(brands);
//
//        response.setContentType("text/plain");
//        response.setCharacterEncoding("utf-8");
//        response.getWriter().write(json);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
