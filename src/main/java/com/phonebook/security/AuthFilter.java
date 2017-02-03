package com.phonebook.security;

import com.phonebook.domain.CustomerProfile;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/products")
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter success");

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
