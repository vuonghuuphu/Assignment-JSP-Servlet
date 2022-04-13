package com.example.assignmentjspservlet.Controller.AdminController.categories;

import com.example.assignmentjspservlet.Entity.CategoriesModel;
import com.example.assignmentjspservlet.Entity.ProductModel;
import com.example.assignmentjspservlet.Model.Categories;
import com.example.assignmentjspservlet.Model.Product;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class deletecategories extends HttpServlet {
    private CategoriesModel model = new CategoriesModel();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Categories obj = null;
        try {
            obj = model.findbyId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (obj == null){
            resp.setStatus(404);
            resp.getWriter().println("Not found");
        }else{
            model.delete(id);
            resp.sendRedirect("/AssignmentJSPServlet_war_exploded/admin/categories");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Categories obj = null;
        try {
            obj = model.findbyId(id);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (obj == null){
            resp.setStatus(404);
            resp.getWriter().println("Not found");
        }else{
            model.delete(id);
            resp.sendRedirect("/AssignmentJSPServlet_war_exploded/admin/categories");
        }
    }
}
