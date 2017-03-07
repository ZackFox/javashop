package com.javashop.controller;

import com.google.gson.Gson;
import com.javashop.DAO.CategoryDao;
import com.javashop.DAO.CategoryDaoimpl;
import com.javashop.DAO.ProductDao;
import com.javashop.DAO.ProductDaoImpl;
import com.javashop.model.CategoryEntity;
import com.javashop.model.ProductEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/catalog/category")
public class ProductsController extends HttpServlet {
    ProductDao dao = new ProductDaoImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cat_id = Integer.valueOf(request.getParameter("id"));
        String type = request.getParameter("type");

        if(type.equals("root")){
            CategoryEntity category = null;
            List<CategoryEntity> list = (List<CategoryEntity>)request.getServletContext().getAttribute("categories");

            for (CategoryEntity c : list) {
                if (c.getId() == cat_id)
                    category = c;
            }

            request.setAttribute("subcats",category.getSubCategories());
        }
        else if(type.equals("sub")){
            List<ProductEntity> products = dao.getProductsByCategoryId(cat_id, 10,0);
            request.setAttribute("products",products);
        }

        request.getRequestDispatcher("/WEB-INF/views/products.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int cat_id = Integer.valueOf(request.getParameter("catId"));
        int offset = Integer.valueOf(request.getParameter("shift"));

        List<ProductEntity> products = dao.getProductsByCategoryId(cat_id, 10, offset);
        String json = new Gson().toJson(products);

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }
}


