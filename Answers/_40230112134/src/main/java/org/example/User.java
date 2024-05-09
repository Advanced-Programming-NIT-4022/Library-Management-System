package org.example;

import java.io.*;
import java.util.*;

public class User extends UniqueID {
    Book book = new Book();
    private String Name;
    private String IDUser ;
    private String PhoneNumber;
    public User(String name , String phoneNumber )
    {
        this.Name = name;
        this.PhoneNumber = phoneNumber;
        this.IDUser = getUniqueID();
    }
    public User() {}
    public String getPhoneNumber() {
        return PhoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
    public String getIDUser() {
        return IDUser;
    }
    public void setIDUser(String IDUser) {
        this.IDUser = IDUser;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }

    public void WriteFileBook(String filepath)
    {
        try  {
            FileWriter writer = new FileWriter(filepath);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (String temp : book.Total)
            {
                bufferedWriter.write(temp);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e){
            System.out.println("Wrong");
        }
    }
    public void ReadFileBook(String filepath)
    {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath));
            String line;
            book.Total.clear();
            while ((line = bufferedReader.readLine()) != null)
            {
                book.Total.add(line);
            }
            bufferedReader.close();
        } catch (IOException r){
            System.out.println("An error occurred.");
        }
    }
    public void AddBook()
    {
        ReadFileBook("Book.txt");
        System.out.println("Enter the name of the book");
        Scanner scanner = new Scanner(System.in);
        book.setTitle(scanner.nextLine());
        System.out.println("Enter the author of the book");
        book.setAuthor(scanner.nextLine());
        System.out.println("Write a description of the book in one line");
        book.setDescription(scanner.nextLine());
        book.setAvailabilityStatus(true);
        for (int i = 0; i < book.Total.size(); i++)
        {
            String line = book.Total.get(i);
            String[] list = line.split("/");
            if (Objects.equals(book.getTitle(), list[1]) || Objects.equals(book.getAuthor(), list[2]) || Objects.equals(book.getDescription(), list[3]))
            {
                System.out.println("you can not add the book");
                System.out.println("because we have that");
            }
            else
            {
                book.Total.add(book.getID() + "/" + book.getTitle() + "/" + book.getAuthor() + "/" + book.getDescription() + "/" + book.getAvailabilityStatus());
                WriteFileBook("Book.txt");
                System.out.println("The book has been successfully added");
                System.out.println("Your Unique ID is : " + book.getID());
                break;
            }
        }
    }
    public String SearchBook(String sentence)
    {
        String flag = "0";
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader("Book.txt"));
            String line;
            while ((line = bufferedReader.readLine()) != null)
            {
                String[] list = line.split("/");
                for (int i = 0; i < list.length; i++)
                {
                    if (Objects.equals(list[i], sentence))
                    {
                        System.out.println("Your ID book: " + list[0]);
                        System.out.println("Your Title: " + list[1]);
                        System.out.println("Your Author: " + list[2]);
                        System.out.println("Your Description: " + list[3]);
                        System.out.println("Your Availability Status: " + list[4]);
                        flag = list[0];
                    }
                    else
                    {
                    }
                }
            }
            bufferedReader.close();
        }catch (IOException e){
            System.out.println("Wrong");
        }
        return flag;
    }
    public void Delete(String number)
    {
        ReadFileBook("Book.txt");
        for (int i = 0; i < book.Total.size(); i++)
        {
            String line1 = book.Total.get(i);
            String[] list = line1.split("/");
            if (Objects.equals(list[0], number))
            {
                System.out.println("Successful");
                book.Total.remove(i);
            }
        }
        WriteFileBook("Book.txt");
    }
}