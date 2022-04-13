package com.example.assignmentjspservlet.Controller.AdminController.categories;

import com.example.assignmentjspservlet.Entity.CategoriesModel;
import com.example.assignmentjspservlet.Model.Categories;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class UpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoriesModel m = new CategoriesModel();
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            Categories p =  m.findbyId(id);
            req.setAttribute("d", p);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        req.getRequestDispatcher("/Admin/categories_update.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int Id = Integer.parseInt(req.getParameter("Id"));
        String Name = req.getParameter("Name");
        String img = req.getParameter("img");
        int Status = Integer.parseInt(req.getParameter("Status"));
        Categories p = new Categories(Id,Name,Status,img);
        CategoriesModel m = new CategoriesModel();
        m.update(Id,p);
        resp.sendRedirect("/AssignmentJSPServlet_war_exploded/admin/categories");
    }
}
