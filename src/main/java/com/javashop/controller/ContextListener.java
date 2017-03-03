package com.javashop.controller;

import com.javashop.DAO.CategoryDao;
import com.javashop.DAO.CategoryDaoimpl;
import com.javashop.model.CategoryEntity;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent contextEvent) {
        ServletContext ctx = contextEvent.getServletContext();
        CategoryDao dao = new CategoryDaoimpl();

        List<CategoryEntity> categories = dao.getAllCategorie();
        for (int i = 0; i < categories.size(); i++) {
            for (int j = i; j < categories.size();) {
                if(categories.get(j).getParentId() !=0 && categories.get(i).getId() == categories.get(j).getParentId()){
                    categories.get(i).getSubCategories().add(categories.get(j));
                    categories.remove(j);
                    continue;
                }
                else {
                    j++;
                }
            }
        }
        ctx.setAttribute("categories", categories);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
