package com.example.assignmentjspservlet.Controller.AdminController.categories;

import com.example.assignmentjspservlet.Entity.CategoriesModel;
import com.example.assignmentjspservlet.Model.Categories;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashSet;

public class DetailCategories extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
                CategoriesModel m = new CategoriesModel();
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            Categories p =  m.findbyId(id);
            req.setAttribute("detail",p);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/Admin/categories_detail.jsp").forward(req,resp);

    }
}
