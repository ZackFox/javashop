package com.javashop.controller;

import com.javashop.DAO.CategoryDao;
import com.javashop.DAO.CategoryDaoimpl;
import com.javashop.model.Category;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent contextEvent) {
        ServletContext ctx = contextEvent.getServletContext();
        CategoryDao dao = new CategoryDaoimpl();
        ctx.setAttribute("categories", Category.splitCategories(dao.getAllCategories()));
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
