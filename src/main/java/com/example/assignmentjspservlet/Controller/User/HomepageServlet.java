package com.example.assignmentjspservlet.Controller.User;

import com.example.assignmentjspservlet.Entity.ProductModel;
import com.example.assignmentjspservlet.Model.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class HomepageServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductModel m = new ProductModel();
        List<Product> l = m.findAll();
        req.setAttribute("l",l);
        req.getRequestDispatcher("/Homepage.jsp").forward(req,resp);
    }
}
