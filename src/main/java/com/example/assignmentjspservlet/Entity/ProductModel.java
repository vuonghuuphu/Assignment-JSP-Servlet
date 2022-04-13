package com.example.assignmentjspservlet.Entity;

import com.example.assignmentjspservlet.Model.Categories;
import com.example.assignmentjspservlet.Model.Product;
import util.ConnectionHelper;
import util.SqlConfig;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductModel {

    static Categories ob = new Categories();

    public List<Product> findAll(){
        List<Product> list = new ArrayList<>();
        ConnectionHelper connectionHelper = new ConnectionHelper();
        try {

            Connection connection = connectionHelper.getConnection();
            String sqlSelect = SqlConfig.LIST_PRODUCT;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            while (resultSet.next()){
                int Id = resultSet.getInt("Id");
                String Name = resultSet.getString("Name");
                int Status = resultSet.getInt("Status");
                int idCategories = resultSet.getInt("IdCategories");
                String img = resultSet.getString("Img");
                String content = resultSet.getString("Content");
                double price = resultSet.getDouble("Price");
                String createdAt = resultSet.getString("CreatedAt");
                String updatedAt = resultSet.getString("UpdatedAt");
                //int id, String name, int idCategories, String content, String img, Double price, Date createdAt, Date updatedAt, int status
                Product pro = new Product(Id,Name,idCategories,content,img,price,createdAt,updatedAt,Status);
                list.add(pro);
            }
        }catch (Exception e){
        }
        return list;
    }

    public boolean save(Product obj){
        try
        {
            //(Name, IdCategories, Content, Img, Price, CreatedAt)
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConfig.INSERT_PRODUCT);
            preparedStatement.setString(1, obj.getName());
            preparedStatement.setInt(2, obj.getIdCategories());
            preparedStatement.setString(3, obj.getContent());
            preparedStatement.setString(4, obj.getImg());
            preparedStatement.setDouble(5, obj.getPrice());
            preparedStatement.setString(6, obj.getCreatedAt());
            preparedStatement.execute();
            return true;
        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return false;
    }

    public Product findbyId(int id) throws SQLException, ClassNotFoundException {
        Product obj = null;
        Connection connection = null;
            connection = ConnectionHelper.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlConfig.DETAIL_PRODUCT);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            int Id = resultSet.getInt("Id");
            String Name = resultSet.getString("Name");
            int Status = resultSet.getInt("Status");
            int idCategories = resultSet.getInt("IdCategories");
            String img = resultSet.getString("Img");
            String content = resultSet.getString("Content");
            double price = resultSet.getDouble("Price");
            String createdAt = resultSet.getString("CreatedAt");
            String updatedAt = resultSet.getString("UpdatedAt");
            obj = new Product(Id,Name,idCategories,content,img,price,createdAt,updatedAt,Status);
        }
        return  obj;
    }
    public boolean update(int id, Product obj) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement(SqlConfig.UPDATE_PRODUCT);
            statement.setInt(1,id);
            statement.setString(2, obj.getName());
            statement.setInt(3, obj.getIdCategories());
            statement.setString(4, obj.getContent());
            statement.setString(5, obj.getImg());
            statement.setDouble(6, obj.getPrice());
            statement.setString(7, obj.getCreatedAt());
            statement.setString(8, obj.getUpdatedAt());
            statement.setInt(9, obj.getStatus());
            statement.setInt(10, id);
            statement.execute();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int id) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement(SqlConfig.DELETE_PRODUCT);
            statement.setInt(1,id);
            statement.execute();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

}


