package com.javashop.controller;

import com.google.gson.Gson;
import com.javashop.DAO.ProductDao;
import com.javashop.DAO.ProductDaoImpl;
import com.javashop.model.Brand;
import com.javashop.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/cart/add")
public class CartController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cart = request.getParameter("item");
        System.out.println(cart);

        List<Product> cartList = new ArrayList<>();
    }
}
