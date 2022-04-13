package com.example.assignmentjspservlet.Controller.AdminController.categories;

import com.example.assignmentjspservlet.Entity.CategoriesModel;
import com.example.assignmentjspservlet.Model.Categories;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateCategoriesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/Admin/categoriesfrom.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Name = req.getParameter("Name");
        String img = req.getParameter("img");
Categories cate = new Categories(0,Name,img);
        if (Name.length() <=0 ){
            req.getRequestDispatcher("/Admin/categoriesfrom.jsp").forward(req,resp);
        }
        if (cate.getName().length() < 1){
            req.getRequestDispatcher("/Admin/categoriesfrom.jsp").forward(req,resp);
        }else{
            CategoriesModel m = new CategoriesModel();
            m.save(cate);
            resp.sendRedirect("/AssignmentJSPServlet_war_exploded/admin/categories");
        }



    }
}
