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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class CreateProductServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoriesModel m = new CategoriesModel();
        List<Categories> l = m.findAll();
        req.setAttribute("l",l);
        req.getRequestDispatcher("/Admin/productCreate.jsp").forward(req,resp);
        List<String> lm = new ArrayList<>();
        req.setAttribute("mess",lm);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Name = req.getParameter("Name");
        String img = req.getParameter("img");
        String idcate = req.getParameter("idcate");
        String Content = req.getParameter("Content");
        String Price = req.getParameter("Price");

        Date date = Calendar.getInstance().getTime();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        String strDate = dateFormat.format(date);

        ProductModel m = new ProductModel();
        Product c = new Product(Name,
                Integer.parseInt(idcate),
                Content,
                img,
                Double.parseDouble(Price),
                strDate);
        List<String> lm = new ArrayList<>();
        if (Name.length() <=0 ){
            req.getRequestDispatcher("/Admin/productCreate.jsp").forward(req,resp);
        }
        if (Name.length() < 7 ){
            lm.add("Tên sản phẩm phải lơn hơn 7 kí tự");
        }
        if (Double.parseDouble(Price) <= 0){
            lm.add("Giá bán phải lớn hơn 0");
        }
        if (Double.parseDouble(Price) > 0 && Name.length() > 7){
            m.save(c);
            resp.sendRedirect("/AssignmentJSPServlet_war_exploded/admin/listproducts");
        }else{
        req.setAttribute("mess",lm);
            CategoriesModel m1 = new CategoriesModel();
            List<Categories> l = m1.findAll();
            req.setAttribute("l",l);
        req.getRequestDispatcher("/Admin/productCreate.jsp").forward(req,resp);
        }
    }
}
