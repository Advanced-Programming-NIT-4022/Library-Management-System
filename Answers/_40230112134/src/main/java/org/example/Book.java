package org.example;

import java.util.*;
import java.io.*;

public class Book extends UniqueID {
    private String ID = getID();
    private String Title , Author , Description;
    ArrayList<String> Total = new ArrayList<>();
    boolean AvailabilityStatus;

    public Book()
    {
        this.Title = getTitle();
        this.Description = getDescription();
        this.Author = getAuthor();
    }
    public void setAuthor(String author) { Author = author; }
    public String getAuthor() { return Author; }
    public String getDescription() { return Description; }
    public void setDescription(String description) { Description = description; }
    public void setTitle(String title) { Title = title; }
    public String getTitle() { return Title; }

    public void WriteFileBook()
    {
        try  {
            FileWriter writer = new FileWriter("Book.txt");
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (String temp : Total)
            {
                bufferedWriter.write(temp);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e){
            System.out.println("Wrong");
        }
    }
    public void ReadFileBook()
    {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("Book.txt"));
            String line;
            Total.clear();
            while ((line = bufferedReader.readLine()) != null)
            {
                Total.add(line);
            }
            bufferedReader.close();
        } catch (IOException r){
            System.out.println("An error occurred.");
        }
    }
    public void AddBook()
    {
        ReadFileBook();
        System.out.println("Enter the name of the book");
        Scanner scanner = new Scanner(System.in);
        Title = scanner.nextLine();
        System.out.println("Enter the author of the book");
        Author = scanner.nextLine();
        System.out.println("Write a description of the book in one line");
        Description = scanner.nextLine();
        AvailabilityStatus = true;
        for (int i = 0; i < Total.size(); i++)
        {
            String line = Total.get(i);
            String[] list = line.split("/");
            if (Objects.equals(Title, list[1]) || Objects.equals(Author, list[2]) || Objects.equals(Description, list[3]))
            {
                System.out.println("you can not add the book");
                System.out.println("because we have that");
            }
            else
            {
                Total.add(ID + "/" + Title + "/" + Author + "/" + Description + "/" + AvailabilityStatus);
                WriteFileBook();
                System.out.println("The book has been successfully added");
                System.out.println("Your Unique ID is : " + ID);
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
        ReadFileBook();
            for (int i = 0; i < Total.size(); i++)
            {
                String line1 = Total.get(i);
                String[] list = line1.split("/");
                if (Objects.equals(list[0], number))
                {
                    System.out.println("Successful");
                    Total.remove(i);
                }
            }
        WriteFileBook();
    }
    public void Rent(String number)
    {
        ReadFileBook();
        for (int i = 0; i < Total.size(); i++)
        {
            String line1 = Total.get(i);
            String[] list = line1.split("/");
            if (Objects.equals(list[0], number))
            {
                System.out.println("please read");
                Total.remove(i);
                String temp = list[0] + "/" + list[1] + "/" + list[2] + "/" + list[3] + "/" + "false" ;
                Total.add(temp);
            }
            else
            {
                System.out.println("The book is rented.");
            }
        }
        WriteFileBook();
    }
}