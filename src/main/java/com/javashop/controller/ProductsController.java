package com.javashop.controller;

import com.google.gson.Gson;
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
        int cat_id = 0, brand_id = 0, page = 0;

        if(request.getParameter("id") != null){
            cat_id = Integer.valueOf(request.getParameter("id"));
        }

        if(request.getParameter("brand") != null){
            brand_id = Integer.valueOf(request.getParameter("brand"));
        }

        if(request.getParameter("page") != null){
            page = Integer.valueOf(request.getParameter("page"));
        }

        CategoryEntity category = null;
        List<CategoryEntity> list = (List<CategoryEntity>)request.getServletContext().getAttribute("categories");

        for (CategoryEntity c : list) {
            if (cat_id == c.getId()) category = c;
        }

        if(category.getParentId() == 0){
            request.setAttribute("subCategories", category.getSubCategories());
            request.getRequestDispatcher("/WEB-INF/views/subcategories.jsp").forward(request,response);
        }
        else{
            request.setAttribute("catId",cat_id);
            request.setAttribute("brandId",brand_id);

            request.setAttribute("brands",dao.getBrandsByCategoryId(cat_id));
            request.setAttribute("products",dao.getProductsByCategoryId(cat_id, brand_id, 3, 0));
            request.getRequestDispatcher("/WEB-INF/views/products.jsp").forward(request,response);
            return;
        }


    }


    private void getSubCategories(HttpServletRequest request, HttpServletResponse response  ){

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



    }
}


