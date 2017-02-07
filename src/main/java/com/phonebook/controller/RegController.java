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
import java.util.List;


@WebServlet("/registration/new/profile")
public class RegController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String login = request.getParameter("login");
        String pass = request.getParameter("password");

        CustomerProfile newCustomer = new CustomerProfile();;
        CustomerDao dao = new CustomerDaoImpl();

        List<CustomerProfile> list = dao.getAllCustomers();

        for (CustomerProfile customer : list) {
            if (customer.getLogin().equals(login)){
                request.getRequestDispatcher("/WEB-INF/views/regpage.jsp").forward(request,response);
            }
        }

        newCustomer.setFirstName(firstname);
        newCustomer.setLastName(lastname);
        newCustomer.setEmail(email);
        newCustomer.setLogin(login);
        newCustomer.setPassword(pass);

        dao.addCustomer(newCustomer);

        HttpSession session = request.getSession();
        session.setAttribute("login",newCustomer);
        response.sendRedirect("/products");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/regpage.jsp").forward(request,response);
    }

}
