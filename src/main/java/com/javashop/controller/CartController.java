package com.javashop.controller;

import com.google.gson.Gson;
import com.javashop.DAO.CartDao;
import com.javashop.DAO.CartDaoImpl;
import com.javashop.model.Cart;//REVU лучше чистить лишнее
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
    //REVU проблема с пробелами.
    //REVU Не факт, что Томкат создаст всего один сервлет
    private CartDao cartDao = new CartDaoImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uuid = getCookie(request,"uuid");
        List<CartItem> resultItems = null;// REVU излишняя инициализация.

        if (!uuid.equals("")) //REVU возможна NPE. isEmpty проверяет строку на пустую длину.
            resultItems = cartDao.getCartItems(uuid);
        else
            resultItems = new ArrayList<>(); //REVU Collections.emptyList?

        //REVU почему бы не вынести в общий метод?
        String json = new Gson().toJson(resultItems);
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //REVU Возможна NPE. Возможна NumberFormatException. Где пробелы?
        //REVU лучше parseInt
        int itemId = !request.getParameter("id").equals("")?Integer.valueOf(request.getParameter("id")): 0;
        String method = request.getParameter("method");
        String uuid = getCookie(request,"uuid");

        //REVU Возможна NPE. Очень сложный иф.
        if(method.equals("add")){
            //REVU Возможна NPE.
            if(itemId !=0 && !uuid.equals("")) { //REVU isEmpty?
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
                cookie.setMaxAge(10*3600*24); //REVU магические числа выносим в константу с понятным именем.
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
        //REVU почему бы не вынести в общий метод?
        String json = new Gson().toJson(resultItems);
        response.setContentType("text/plain");//REVU почему plain/text, когда application/json?
        response.setCharacterEncoding("utf-8");
        response.getWriter().write(json);
    }

    private String getCookie(HttpServletRequest request, String cookieName) {
        Cookie[] cookies = request.getCookies();
        //REVU Возможна NPE. - getCookies может вернуть null
        for (Cookie c : cookies){
            if(c.getName().equals(cookieName)) return c.getValue();
        }
        return "";
    }
}
