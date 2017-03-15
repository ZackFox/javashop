package com.javashop.controller;

import com.google.gson.Gson;
import com.javashop.DAO.ProductDao;
import com.javashop.DAO.ProductDaoImpl;
import com.javashop.model.BrandEntity;
import com.javashop.model.ProductEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/get/brand")
public class BrandsJsonController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ProductDao dao = new ProductDaoImpl();
        int catId = Integer.valueOf(request.getParameter("catId"));

        List<BrandEntity> brands = dao.getBrandsByCategoryId(catId);
        String json = new Gson().toJson(brands);

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
