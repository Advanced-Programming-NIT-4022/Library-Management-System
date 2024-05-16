package com.example.lib;
import com.mysql.cj.protocol.Resultset;

import java.sql.*;
import java.util.Objects;
import java.util.Scanner;

public class Library {
    private String libraryName;
    private int Capacity=1000;

    public String getOperatingHours() {
        return operatingHours;
    }

    private String operatingHours="6Am-9Pm";
    Connection connection;
    Statement statement;

    public Library() throws SQLException {
         connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/library");
         statement=  connection.createStatement();

    }

    public void addMember(String name,String phoneNumber,String Id,String Password) throws SQLException {
    statement.executeUpdate("INSERT INTO user (Name,PhoneNumber,Id,Password) VALUES ('"+name+"','"+phoneNumber+"','"+Id+"','"+Password+"')");
    }
    public boolean checkUserexistence(String name,String Password) throws SQLException {
    ResultSet resultSet1=statement.executeQuery("SELECT * FROM user WHERE Password='"+Password+"'");
    boolean a=resultSet1.next();

    resultSet1=statement.executeQuery("SELECT * FROM user WHERE Name='"+name+"'");
     boolean b=resultSet1.next();
     if(a && b){
         return true;
     }
     else
         return false;
    }
    public boolean checkUserexistence2(String Id) throws SQLException {
        ResultSet resultSet1=statement.executeQuery("SELECT * FROM user WHERE Id='"+Id+"'");
        if(resultSet1.next()){
            return true;
        }
        else
            return false;
    }
    public void rmUser(String Id, boolean admin) throws SQLException {
        if(!admin){
            System.out.println("you're not admin.");
            return;
        }
        if(checkUserexistence2(Id)){
            statement.executeUpdate("DELETE FROM user WHERE Id='"+Id+"'");
            System.out.println("Done.");
        }
        else{
            System.out.println("user not found");
            return;
        }
    }
    public void rentBook(String name) throws SQLException {
        ResultSet resultSet1=statement.executeQuery("SELECT * FROM book WHERE Title='"+name+"' AND Availabilitystatus='true'");
        if(!resultSet1.next()){
            System.out.println("book is rented or not found");
            return;
        }
        int tedad=0;
        while(resultSet1.next()){
            tedad++;
        }
        if(tedad>1){
            Scanner input=new Scanner(System.in);
            System.out.println("please enter author name: ");
            String author=input.nextLine();
            resultSet1=statement.executeQuery("SELECT * FROM book WHERE Title='"+name+"' AND Author='"+author+"'");
            if(resultSet1.next()){
                statement.executeUpdate("UPDATE book SET Availabilitystatus='false' WHERE  Title='"+name+"' AND Author='"+author+"'" );
            }
        }
        else{
            statement.executeUpdate("UPDATE book SET Availabilitystatus='false' WHERE  Title='"+name+"'" );
            System.out.println("DONE.");
        }

    }



    public void addAdmin(String name,String PhoneNumber,String Password,String Id) throws SQLException {
        statement.executeUpdate("INSERT INTO admin (Name,PhoneNumber,Password,Id) VALUES ('"+name+"','"+PhoneNumber+"','"+Password+"','"+Id+"')");
    }

    public void rmAdmin(String Id) throws SQLException {
        statement.executeUpdate("DELETE FROM admin WHERE Id='"+Id+"'");
        System.out.println("Done.");
    }
    public void addBook(Book book) throws SQLException {
        statement.executeUpdate("INSERT INTO book (Title,Author,Id,Description,Availabilitystatus) VALUES ('"+book.getTitle()+"','"+book.getAuthor()+"','"+book.getBookId()+"','"+book.getDescription()+"','"+String.valueOf(book.isAvailabilityStatus())+"')");
    }
    public void getbooks(String username) throws SQLException {
        if(Objects.equals(username,"")){
            System.out.println("please sign in to use this command.");
            return;
        }
        ResultSet resultSet1=statement.executeQuery("SELECT * FROM book WHERE Availabilitystatus='true'");
        while(resultSet1.next()){
            System.out.println("Title: "+resultSet1.getString("Title"));
            System.out.println("Author: "+resultSet1.getString("Author"));
            System.out.println("Description: "+resultSet1.getString("Description"));
            System.out.println("*****************************");

        }
    }
    public void returnBook(String name, String username) throws SQLException {
        if(Objects.equals(username,"")){
            System.out.println("please sign in to use this command");
            return;
        }
        ResultSet resultSet1=statement.executeQuery("SELECT * FROM book WHERE Title='"+name+"' AND Availabilitystatus='false'");
        if(!resultSet1.next()){
            System.out.println("book is not rented or doesnt exist");
            return;
        }
        int tedad=0;
        while(resultSet1.next()){
            tedad++;
        }
        if(tedad>1){
            Scanner input=new Scanner(System.in);
            System.out.println("please enter author name: ");
            String author=input.nextLine();
            resultSet1=statement.executeQuery("SELECT * FROM book WHERE Title='"+name+"' AND Author='"+author+"'");
            if(resultSet1.next()){
                statement.executeUpdate("UPDATE book SET Availabilitystatus='true' WHERE  Title='"+name+"' AND Author='"+author+"'" );
            }
        }
        else{
            statement.executeUpdate("UPDATE book SET Availabilitystatus='true' WHERE  Title='"+name+"'" );
            System.out.println("DONE.");
        }

    }
    public User getUserbyId(String id,boolean admin) throws SQLException {
        if(admin){
            ResultSet resultSet1=statement.executeQuery("SELECT * FROM admin WHERE Id='"+id+"'");
            Admin admin1=new Admin(resultSet1.getString("Name"),resultSet1.getString("PhoneNumber"),resultSet1.getString("Password"),resultSet1.getString("Id"));
            return admin1;
        }
        else{
            ResultSet resultSet1=statement.executeQuery("SELECT * FROM user WHERE Id='"+id+"'");
            normalUser user=new normalUser(resultSet1.getString("Name"),resultSet1.getString("PhoneNumber"),resultSet1.getString("Password"),resultSet1.getString("Id"));
            return user;
        }

    }
    public String getBookIdbyName(String name) throws SQLException {

            ResultSet resultSet1=statement.executeQuery("SELECT * FROM book WHERE Title='"+name+"'");
            String Id=resultSet1.getString("Id");
            resultSet1.close();
            return Id;


    }



    public void rentUser(String bookName,String userId,boolean admin) throws SQLException {
        Rent rent =new Rent();

        statement.executeUpdate("INSERT INTO rent (Id,userId,bookId,Datee) VALUES ('"+rent.getRentId()+"','"+userId+"','"+bookName+"','"+rent.getRentDate().toString()+"')");
        try{
            statement.executeUpdate("UPDATE book SET Availabilitystatus='false' WHERE  Title='"+bookName+"'" );

        }
catch (Exception e){
    System.out.println("book not found");
}
        System.out.println("DONE.");
    }
}
