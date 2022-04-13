package com.example.assignmentjspservlet.Controller;

import com.example.assignmentjspservlet.Entity.AccountModel;
import com.example.assignmentjspservlet.Model.Account;
import util.PasswordHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/Auth/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        AccountModel accountModel = new AccountModel();
        String username = req.getParameter("username");
        String pass = req.getParameter("pass");

        Account account = accountModel.findAccountByUsername(username);
        if (account == null){
            resp.getWriter().println("login that bai");
        return;
    }
        if ( account.getStatus() == 2){
            if (LocalDateTime.now().compareTo(account.getLocktime())>0){
                account.setStatus(1);
                account.setFailureCount(0);
                accountModel.updateLock(account.getUsername(),account);
            }else{
                resp.getWriter().println("lock");
            }
        }
        boolean result = PasswordHandler.checkPassword(pass,account.getPasswordHash(),account.getSalt());
        if (result){
            HttpSession session = req.getSession();
            session.setAttribute("currentAccount" ,account);
            if (account.getRole() == 2){
                resp.sendRedirect("/AssignmentJSPServlet_war_exploded/admin");
            }else{
                resp.sendRedirect("/AssignmentJSPServlet_war_exploded");
            }

//            resp.getWriter().println("Login");
        }else {
            if (account.getFailureCount() == 1){
                account.setFailureCount(account.getFailureCount()+1);
                account.setStatus(2);
                account.setLocktime(LocalDateTime.now().plusMinutes(5));
                accountModel.updateLock(account.getUsername(),account);
            }
            resp.getWriter().println("Login that bai");
        }

        }
    }

