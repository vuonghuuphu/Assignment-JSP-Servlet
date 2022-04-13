package com.example.assignmentjspservlet.filter;

import com.example.assignmentjspservlet.Model.Account;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Userfilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("user filter");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        Account account = (Account)session.getAttribute("currentAccount");
        if (account == null ){
            response.sendRedirect("/AssignmentJSPServlet_war_exploded/Food/Login");
        }else{
            System.out.println("account"+account.getUsername());
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {
        System.out.println("end user filter");
        Filter.super.destroy();
    }
}
