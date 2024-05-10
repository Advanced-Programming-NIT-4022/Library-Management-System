package com.example.lib;
import java.sql.*;

public class Library {
    private String libraryName;
    private int Capacity;
    Connection connection;
    Statement statement;

    public Library() throws SQLException {
         connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/library");
         statement=  connection.createStatement();

    }

    public void addMember(String name,String phoneNumber) throws SQLException {
    statement.executeUpdate("INSERT INTO user (Name,PhoneNumber) VALUES ('"+name+"','"+phoneNumber+"')");
    }
    public boolean checkUserexistence(String Id) throws SQLException {
     ResultSet resultSet=statement.executeQuery("SELECT * FROM user WHERE Id='"+Id+"'");
     if(resultSet.next()){
         return true;
     }
     else
         return false;
    }
    public void rmUser(String Id) throws SQLException {
        if(checkUserexistence(Id)){
            statement.executeUpdate("DELETE FROM user WHERE Id='"+Id+"'");
            System.out.println("Done.");
        }
        else{
            System.out.println("user not found");
            return;
        }
    }



    public void addAdmin(String name,String PhoneNumber,String Password) throws SQLException {
        statement.executeUpdate("INSERT INTO admin (Name,PhoneNumber,Password) VALUES ('"+name+"','"+PhoneNumber+"','"+Password+"')");
    }

    public void rmAdmin(String Id) throws SQLException {
        statement.executeUpdate("DELETE FROM admin WHERE Id='"+Id+"'");
        System.out.println("Done.");
    }
}
