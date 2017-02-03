package com.phonebook.controller;

import com.phonebook.DAO.CustomerDao;
import com.phonebook.DAO.CustomerDaoImpl;
import com.phonebook.domain.CustomerProfile;

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
        // вывод списка товаров

        CustomerDao dao = new CustomerDaoImpl();
        List<CustomerProfile> customers = dao.getAllCustomers();
        request.setAttribute("list", customers);

        request.getRequestDispatcher("/WEB-INF/views/products.jsp").forward(request,response);
    }
}
