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
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@WebServlet("/cart")
public class CartController extends HttpServlet {

    private CartDao cartDao = new CartDaoImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uuid = getCookie(request,"uuid");
        List<CartItem> resultItems = null;

        if (!uuid.equals(""))
            resultItems = cartDao.getCartItems(uuid);
        else
            resultItems = new ArrayList<>();

        String json = new Gson().toJson(resultItems);
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int itemId = !request.getParameter("id").equals("")?Integer.valueOf(request.getParameter("id")): 0;
        String method = request.getParameter("method");
        String uuid = getCookie(request,"uuid");

        if(method.equals("add")){
            if(itemId !=0 && !uuid.equals("")) {
                CartItem item = cartDao.getCartItemById(uuid,itemId);
                if(item.getProductId()== itemId){
                    cartDao.increaseQuantity(uuid,itemId);
                }
                else {
                    cartDao.addToCart(uuid,itemId);
                }
            }
            else{
                String newUuid = UUID.randomUUID().toString();
                cartDao.addToNewCart(newUuid,itemId);
                Cookie cookie = new Cookie("uuid",newUuid);
                cookie.setMaxAge(10*3600*24);
                response.addCookie(cookie);
            }
        }
        else if(method.equals("increase")){
            cartDao.increaseQuantity(uuid,itemId);
        }
        else if(method.equals("decrease")){
            cartDao.decreaseQuantity(-1,uuid,itemId);
        }
        else if(method.equals("delete")){
            cartDao.deleteItem(uuid,itemId);
        }

        List<CartItem> resultItems = cartDao.getCartItems(uuid);
        String json = new Gson().toJson(resultItems);
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    private String getCookie(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();
        for (Cookie c : cookies){
            if(c.getName().equals(cookieName)) return c.getValue();
        }
        return "";
    }
}
