package com.example.assignmentjspservlet.filter;

import com.example.assignmentjspservlet.Model.Account;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdmindFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Start admin filtert");
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("add filter");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        Account account = (Account)session.getAttribute("currentAccount");
        System.out.println(account.toString());
        if (account == null || account.getRole() != 2 ){
            response.sendRedirect("/AssignmentJSPServlet_war_exploded/Food/Login");
        }else{
            System.out.println("account"+account.getUsername());
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {
        System.out.println("end admin filter");
        Filter.super.destroy();
    }
}
