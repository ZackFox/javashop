package com.javashop.controller;

import com.javashop.DAO.CustomerDao;
import com.javashop.DAO.CustomerDaoImpl;
import com.javashop.model.CustomerProfile;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URL;


@WebServlet("/login")
public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String pass = request.getParameter("password");
        String path = request.getHeader("Referer").substring(21);

        System.out.println(request.getHeader("Referer").substring(21));

        CustomerDao dao = new CustomerDaoImpl();
        if (login!=null && pass!=null && !login.equals("") && !pass.equals("")){
            CustomerProfile customer = dao.getCustomerByLogin(login,pass);

            if (!customer.getLogin().equals(login) && !customer.getPassword().equals(pass)){
                response.sendRedirect(path);
                return;
            }

            HttpSession session = request.getSession();
            session.setAttribute("login", customer.getLogin());
            session.setAttribute("customer", customer);

            response.sendRedirect(path);
        }
        else{
            response.sendRedirect(path);
        }
    }
}
