package com.example.assignmentjspservlet.Controller.Product;

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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class UpdateProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductModel m = new ProductModel();
        int id = Integer.parseInt(req.getParameter("id"));
        try {
            Product p =  m.findbyId(id);
            req.setAttribute("d", p);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        CategoriesModel m1 = new CategoriesModel();
        List<Categories> l = m1.findAll();
        req.setAttribute("l",l);
        req.getRequestDispatcher("/Admin/productsupdate.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int Id = Integer.parseInt(req.getParameter("Id"));
        String Name = req.getParameter("Name");
        String img = req.getParameter("img");
        int Status = Integer.parseInt(req.getParameter("Status"));
        int idcate = Integer.parseInt(req.getParameter("idcate"));
        String Content = req.getParameter("Content");
        Double Price = Double.parseDouble(req.getParameter("Price"));
        String CreateAt = req.getParameter("CreateAt");
        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        String strDate = dateFormat.format(date);
        Product c = new Product(
                Id,Name,idcate,Content,img,Price,CreateAt,strDate,Status);
        ProductModel m = new ProductModel();
        m.update(Id,c);
        resp.sendRedirect("/AssignmentJSPServlet_war_exploded/admin/listproducts");
    }
}
