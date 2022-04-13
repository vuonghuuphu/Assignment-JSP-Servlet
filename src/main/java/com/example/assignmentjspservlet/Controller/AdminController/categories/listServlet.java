package com.example.assignmentjspservlet.Controller.AdminController.categories;

import com.example.assignmentjspservlet.Entity.CategoriesModel;
import com.example.assignmentjspservlet.Model.Categories;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class listServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoriesModel m = new CategoriesModel();
        List<Categories> l = m.findAll();
        req.setAttribute("l",l);
        req.getRequestDispatcher("/Admin/categories.jsp").forward(req,resp);
    }
}
