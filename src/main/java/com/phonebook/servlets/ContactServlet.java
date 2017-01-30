package com.phonebook.servlets;

import com.phonebook.DAO.UserDao;
import com.phonebook.DAO.UserDaoImpl;
import com.phonebook.domain.UserProfile;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Сергей on 26.01.2017.
 */
@WebServlet("/get/contacts")
public class ContactServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao dao = new UserDaoImpl();
        List<UserProfile> contacts = dao.getAllContacts();
        request.setAttribute("list", contacts);
        request.getRequestDispatcher("/WEB-INF/views/contacts.jsp").forward(request,response);
    }
}
