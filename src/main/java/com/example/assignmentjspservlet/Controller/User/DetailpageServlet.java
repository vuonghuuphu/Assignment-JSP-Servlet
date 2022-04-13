package com.example.assignmentjspservlet.Controller.User;

import com.example.assignmentjspservlet.Entity.ProductModel;
import com.example.assignmentjspservlet.Model.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class DetailpageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductModel m = new ProductModel();
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            Product p =  m.findbyId(id);
            req.setAttribute("detail",p);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/detailpage.jsp").forward(req,resp);

    }
}
