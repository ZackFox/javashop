package com.javashop.controller;

import com.javashop.DAO.ProductDao;
import com.javashop.DAO.ProductDaoImpl;
import com.javashop.model.Category;

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
        int cat_id = 1, brand_id = 0, offset = 0, limit = 4;

        if(request.getParameter("id") != null){
            cat_id = Integer.valueOf(request.getParameter("id"));
        }

        if(request.getParameter("brand") != null){
            brand_id = Integer.valueOf(request.getParameter("brand"));
        }

        if(request.getParameter("offset") != null){
            offset = Integer.valueOf(request.getParameter("offset"));
        }

        Category category = null;
        List<Category> list = (List<Category>)request.getServletContext().getAttribute("categories");

        for (Category c : list) {
            if (cat_id == c.getId()) category = c;
        }

        if(category.getParentId() == 0){
            request.setAttribute("subCategories", category.getSubCategories());
            request.getRequestDispatcher("/WEB-INF/views/subcategories.jsp").forward(request,response);
        }
        else{
            request.setAttribute("catId",cat_id);
            request.setAttribute("brandId",brand_id);
            request.setAttribute("offset",offset);
            request.setAttribute("limit",limit);

            request.setAttribute("products", dao.getProductsByCategoryId(cat_id, brand_id,limit+1,offset));
            request.setAttribute("brands",dao.getBrandsByCategoryId(cat_id));
            request.getRequestDispatcher("/WEB-INF/views/products.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }
}


