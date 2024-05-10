package com.example.lib;
import java.sql.*;

public class Library {
    private String libraryName;
    private int Capacity;
    public void addMember(String name,String phoneNumber) throws SQLException {
    Connection connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/library");
    Statement statement=  connection.createStatement();
    statement.executeUpdate("INSERT INTO user (Name,PhoneNumber) VALUES ('"+name+"','"+phoneNumber+"')");

    }
}
