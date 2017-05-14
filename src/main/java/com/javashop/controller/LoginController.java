package com.javashop.controller;

import com.google.gson.Gson;//REVU не используется
import com.javashop.DAO.CustomerDao;
import com.javashop.DAO.CustomerDaoImpl;
import com.javashop.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet("/login")
public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String pass = request.getParameter("password");

        String url = request.getHeader("Referer");
        String path = url.substring(url.indexOf('/',10)); //REVU зачем эта переменная? Магическое число?

        CustomerDao dao = new CustomerDaoImpl(); //REVU дао на каждый запрос создаешь? Чудненько.
        Customer customer = dao.getCustomerByLogin(login,pass);
        //REVU login и pass могут быть null. Проверка в ДАО есть?
        if (!customer.getLogin().equals(login) && !customer.getPassword().equals(pass)){
            response.getWriter().write("");//REVU Вот так просто? Почему бы 400 ошибку не отдать?
        }
        else{
            HttpSession session = request.getSession();
            session.setAttribute("login",customer.getId());
            session.setAttribute("customer",customer); //REVU не айс. Customer не Serializable
            response.getWriter().write("200");
        }
    }


}
