package com.example.assignmentjspservlet.Model;

public class Categories {
    private int Id;
    private String Name;
    private int Status ;
    private String Img;

    public String getImg() {
        return Img;
    }

    public void setImg(String img) {
        Img = img;
    }

    public Categories(int id, String name, int status, String img) {
        Id = id;
        Name = name;
        Status = status;
        Img = img;
    }

    public Categories(int id, String name , String img) {
        Id = id;
        Name = name;
        Img = img;
    }

    public Categories() {
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

    public int getStatus() {
        return Status;
    }

    public void setStatus(int status) {
        Status = status;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "Id=" + Id +
                ", Name='" + Name + '\'' +
                ", Status=" + Status +
                ", Img='" + Img + '\'' +
                '}';
    }
}
