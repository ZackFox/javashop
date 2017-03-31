package com.javashop.controller;

import com.google.gson.Gson;
import com.javashop.DAO.CartDao;
import com.javashop.DAO.CartDaoImpl;
import com.javashop.model.Cart;
import com.javashop.model.CartItem;
import com.javashop.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;
import java.util.UUID;


@WebServlet("/cart")
public class CartController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uuid = request.getParameter("uuid");

        CartDao cartDao = new CartDaoImpl();
        List<CartItem> resultItems = cartDao.getCartItems(uuid);
        String json = new Gson().toJson(resultItems);

        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int addId = request.getParameter("add")!= null? Integer.valueOf(request.getParameter("add")): 0;
//        String delete = request.getParameter("query");

        String cookie = getCookie(request,"uuid");
        CartDao cartDao = new CartDaoImpl();
        List<CartItem> resultItems = null;

        //добавление продукта в корзину
        if(addId !=0 && !cookie.equals("")) {
            List<CartItem> items = cartDao.getCartItems(cookie);
            boolean isExist = false;

            //если продукт есть увеличить его количество
            for (CartItem i:items){
                if(i.getProductId()== addId){
                    isExist = true;
                    cartDao.increaseQuantity(cookie,addId);
                    System.out.println("количество продукта "+addId+" увеличено");
                }
            }

            //если его в корзине нет - добавить в корзину
            if (isExist == false){
                cartDao.addToCart(cookie,addId);
                System.out.println("продукт "+addId+" добавлен");

            }
        }// если корзины нет в куках - создать корзину и добвить продукт
        else{
            String uuid = UUID.randomUUID().toString();
            cartDao.addToNewCart(uuid,addId);
            response.addCookie(new Cookie("uuid",uuid));
            System.out.println("создана корзина "+uuid+" и добавлен продукт " +addId);
        }

//        if(deleteId !=0 && cookie != "") {
//            List<CartItem> items = cartDao.getCartItems(cookie);
//            boolean isExist = false;
//
//            for (CartItem i:items){
//                if(i.getProductId()== addId){
//                    isExist = true;
//                    cartDao.increaseQuantity(cookie,addId);
//                }
//            }
//
//            if (isExist == false){
//                cartDao.addToCart(cookie,addId);
//            }
//        }
    }

    private String getCookie(HttpServletRequest request,String cookieName) {
        Cookie[] cookies = request.getCookies();

        for (Cookie c : cookies){
            if(c.getName().equals(cookieName)){
                return c.getValue();
            }
        }
        return "";
    }
}
