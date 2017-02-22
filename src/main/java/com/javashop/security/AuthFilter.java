package com.javashop.security;

import com.javashop.DAO.CategoryDao;
import com.javashop.DAO.CategoryDaoimpl;
import com.javashop.model.CategoryEntity;
import com.javashop.model.CustomerProfile;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

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

        if(request.getServletContext().getAttribute("categories") == null){
            CategoryDao dao = new CategoryDaoimpl();
            request.getServletContext().setAttribute("categories",dao.getAllCategorie());
        }

        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
