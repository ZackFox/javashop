package com.phonebook.security;

import com.phonebook.model.CustomerProfile;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = "/cabinet")
public class SuccessFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("cabinet filter");

        HttpSession session = ((HttpServletRequest) request).getSession();
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        if(session.getAttribute("login") == null ){
            httpResponse.sendRedirect("/products");
            return;
        }
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
