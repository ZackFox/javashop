package com.javashop.controller;

import com.javashop.DAO.CategoryDao;
import com.javashop.DAO.CategoryDaoimpl;
import com.javashop.model.Category;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServletRequest;//REVU не использумые зависимости
import javax.servlet.http.HttpSession;

public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent contextEvent) {
        ServletContext ctx = contextEvent.getServletContext();
        CategoryDao dao = new CategoryDaoimpl();//REVU под вопросом
        ctx.setAttribute("categories", Category.splitCategories(dao.getAllCategories()));
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        //REVU Зачем этот метод? Кто удалять будет?
    }
}
