package com.javashop.filters;


import com.javashop.model.Customer;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebFilter(urlPatterns = "/*")
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) request).getSession();

        if(session.getAttribute("login") == null ){
            session.setAttribute("customer", new Customer());
        }

        if(session.getAttribute("cart") == null ){
            List<Integer> cart = new ArrayList<>();
            session.setAttribute("cart", cart);
        }

        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
