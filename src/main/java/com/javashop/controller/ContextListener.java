package com.javashop.controller;

import com.javashop.DAO.CategoryDao;
import com.javashop.DAO.CategoryDaoimpl;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent contextEvent) {
        CategoryDao dao = new CategoryDaoimpl();
        ServletContext ctx = contextEvent.getServletContext();
        ctx.setAttribute("categories",dao.getAllCategorie());
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
