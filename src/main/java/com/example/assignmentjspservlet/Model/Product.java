package com.example.assignmentjspservlet.Model;

import java.util.Date;

public class Product {
    private int Id;
    private String Name;
    private int IdCategories;
    private String Content;
    private String Img;
    private Double Price;
    private String CreatedAt;
    private String UpdatedAt;
    private int Status;

    @Override
    public String toString() {
        return "Product{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", IdCategories=" + IdCategories +
                ", Content='" + Content + '\'' +
                ", Img='" + Img + '\'' +
                ", Price=" + Price +
                ", CreatedAt=" + CreatedAt +
                ", UpdatedAt=" + UpdatedAt +
                ", Status=" + Status +
                '}';
    }

    public Product() {
    }

    public Product(String name, int idCategories, String content, String img, Double price,String createdAt) {
        Name = name;
        IdCategories = idCategories;
        Content = content;
        Img = img;
        Price = price;
        CreatedAt = createdAt;
    }

    public Product(int id, String name, int idCategories, String content, String img, Double price, String createdAt, String updatedAt, int status) {
        Id = id;
        Name = name;
        IdCategories = idCategories;
        Content = content;
        Img = img;
        Price = price;
        CreatedAt = createdAt;
        UpdatedAt = updatedAt;
        Status = status;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getIdCategories() {
        return IdCategories;
    }

    public void setIdCategories(int idCategories) {
        IdCategories = idCategories;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getImg() {
        return Img;
    }

    public void setImg(String img) {
        Img = img;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

    public String getCreatedAt() {
        return CreatedAt;
    }

    public void setCreatedAt(String createdAt) {
        CreatedAt = createdAt;
    }

    public String getUpdatedAt() {
        return UpdatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        UpdatedAt = updatedAt;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }
}
