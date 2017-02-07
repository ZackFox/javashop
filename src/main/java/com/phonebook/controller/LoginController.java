package com.phonebook.controller;

import com.phonebook.DAO.CustomerDao;
import com.phonebook.DAO.CustomerDaoImpl;
import com.phonebook.model.CustomerProfile;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet("/login")
public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String pass = request.getParameter("password");

        CustomerDao dao = new CustomerDaoImpl();
        if (login!=null && pass!=null){
            CustomerProfile customer = dao.getCustomerByLogin(login,pass);

            if (!customer.getLogin().equals(login) && !customer.getPassword().equals(pass)){
                response.sendRedirect("/products");
                return;
            }

            HttpSession session = request.getSession();
            session.setAttribute("login", customer.getLogin());
            session.setAttribute("customer", customer);
            response.sendRedirect("/products");
        }
        else{
            response.sendRedirect("/products");
        }
    }
}
