package com.javashop.filters;


import com.javashop.model.CustomerProfile;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/catalog/*")
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpSession session = ((HttpServletRequest) request).getSession();

        if(session.getAttribute("login") == null ){
            session.setAttribute("customer",new CustomerProfile());
        }

        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
