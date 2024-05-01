package org.example;

import java.util.*;
import java.io.*;

public class Book extends UniqueID {
    String ID = getID();
    String Title , Author , Description;
    ArrayList<String> Total = new ArrayList<>();
    boolean AvailabilityStatus;
    public void AddBook()
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
            r.printStackTrace();
        }
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
            if (Objects.equals(Title, list[1]))
            {
                System.out.println("you can not add the book");
                System.out.println("because we have that");
            }
            else
            {
                Total.add(ID + "/" + Title + "/" + Author + "/" + Description + "/" + AvailabilityStatus);
                while (true)
                {
                    try {
                        FileWriter writer = new FileWriter("Book.txt");
                        BufferedWriter bufferedWriter = new BufferedWriter(writer);
                        for (String temp : Total)
                        {
                            bufferedWriter.write(temp);
                            bufferedWriter.newLine();
                        }
                        bufferedWriter.close();
                        System.out.println("The book has been successfully added");
                        System.out.println("Your Unique ID is : " + ID);
                        bufferedWriter.close();
                        break;
                    } catch (IOException e){
                        System.out.println("An error occurred.");
                        System.out.println("Try Again");
                        e.printStackTrace();
                    }
                }
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
            e.printStackTrace();
        }
        return flag;
    }
    public void Delete(String number)
    {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("Book.txt"));
            String line;
            Total.clear();
            while ((line = bufferedReader.readLine()) != null)
            {
                Total.add(line);
            }
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
            bufferedReader.close();
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
            e.printStackTrace();
        }
    }
}
