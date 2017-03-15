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
        int catId = 0; int brand = 0;

        if(request.getParameter("id") != null){
            catId = Integer.valueOf(request.getParameter("id"));
        }

        if(request.getParameter("brand") != null){
            brand = Integer.valueOf(request.getParameter("brand"));
        }

        List<CategoryEntity> list = (List<CategoryEntity>)request.getServletContext().getAttribute("categories");

        CategoryEntity category = null;
        for (CategoryEntity c : list) {
            if (catId == c.getId()) category = c;
        }

        if(category.getParentId() == 0){
            request.setAttribute("subCategories",category.getSubCategories());
            request.getRequestDispatcher("/WEB-INF/views/subcategories.jsp").forward(request,response);
            return;
        }
        else{
            if(brand>0){
                request.setAttribute("products",dao.getFilteredProductsByCategoryId(brand,catId,10,0));
            }
            else{
                request.setAttribute("products",dao.getProductsByCategoryId(catId,5,0));
            }

            request.setAttribute("catId",catId);
            request.setAttribute("brands",dao.getBrandsByCategoryId(catId));
            request.getRequestDispatcher("/WEB-INF/views/products.jsp").forward(request,response);
            return;
        }


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


