package com.example.assignmentjspservlet.Controller;

import com.example.assignmentjspservlet.Entity.AccountModel;
import com.example.assignmentjspservlet.Model.Account;
import util.PasswordHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;



public class RegisterServlet  extends HttpServlet {

    static AccountModel  accountmodel = new AccountModel();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/Auth/register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String fullname = req.getParameter("fullname");
        String pass = req.getParameter("pass");
        String conpass = req.getParameter("conpass");

        Account account = new Account();
        account.setUsername(username);
        account.setFullname(fullname);
        String salt = PasswordHandler.generateSalt();
        account.setSalt(salt);
        String passwordhandler = PasswordHandler.getMd5(pass,salt);
        account.setPasswordHash(passwordhandler);
        account.setStatus(1);
        account.setCreatedAt(Calendar.getInstance().getTime().toString());
        boolean result = accountmodel.save(account);
        if (result) {
        resp.getWriter().println("register ok");
        }else{
            resp.getWriter().println("Erro");
        }
        }

    }

