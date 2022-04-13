package com.example.assignmentjspservlet.Entity;

import com.example.assignmentjspservlet.Model.Categories;
import util.ConnectionHelper;
import util.SqlConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriesModel {

    static Categories ob = new Categories();

    public List<Categories> findAll(){
        List<Categories> list = new ArrayList<>();
        ConnectionHelper connectionHelper = new ConnectionHelper();
        try {

            Connection connection = connectionHelper.getConnection();
            String sqlSelect = SqlConfig.LIST_CATEGORIES;
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlSelect);
            while (resultSet.next()){
                int Id = resultSet.getInt("Id");
                String Name = resultSet.getString("Name");
                int Status = resultSet.getInt("Status");
                String Img = resultSet.getString("Img");
                Categories student = new Categories(Id,Name,Status,Img);
                list.add(student);
            }
        }catch (Exception e){
        }
        return list;
    }

    public boolean save(Categories obj){
        try
        {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SqlConfig.INSERT_CATEGORIES);
            preparedStatement.setString(1, obj.getName());
            preparedStatement.setString(2, obj.getImg());
            preparedStatement.execute();
            return true;
        }catch(SQLException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return false;
    }

    public Categories findbyId(int id) throws SQLException, ClassNotFoundException {
        Categories obj = null;
        Connection connection = null;
            connection = ConnectionHelper.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SqlConfig.DETAIL_CATEGORIES);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            int Id = resultSet.getInt("Id");
            String Name = resultSet.getString("Name");
            String Img = resultSet.getString("Img");
            int Status = resultSet.getInt("Status");
            obj = new Categories(Id,Name,Status,Img);
        }
        return  obj;
    }
    public boolean update(int id, Categories obj) {
        try {
            Connection connection = ConnectionHelper.getConnection();
            PreparedStatement statement = connection.prepareStatement(SqlConfig.UPDATE_CATEGORIES);
            statement.setInt(1, obj.getId());
            statement.setString(2, obj.getName());
            statement.setInt(3, obj.getStatus());
            statement.setString(4, obj.getImg());
            statement.setInt(5, id);
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
            PreparedStatement statement = connection.prepareStatement(SqlConfig.DELETE_CATEGORIES);
            statement.setInt(1,id);
            statement.execute();
            return true;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

}


