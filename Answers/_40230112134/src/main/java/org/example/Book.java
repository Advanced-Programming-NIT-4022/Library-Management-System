package org.example;

import java.util.*;
import java.io.*;

public class Book extends UniqueID {
    String ID = getID();
    String Title , Author , Description ;
    ArrayList<String> Total = new ArrayList<>();
    boolean AvailabilityStatus ;
    public void AddBook()
    {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("Book.txt"));
            String line;
            while ((line = bufferedReader.readLine()) != null)
            {
                Total.add(line);
            }
        } catch (IOException r){
            System.out.println("An error occurred.");
            r.printStackTrace();
        }
        System.out.println("Enter the name of the book");
        Scanner scanner = new Scanner(System.in);
        Title = scanner.nextLine() ;
        System.out.println("Enter the author of the book");
        Author = scanner.nextLine() ;
        System.out.println("Write a description of the book in one line");
        Description = scanner.nextLine() ;
        AvailabilityStatus = true ;
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
                break;
            } catch (IOException e){
                System.out.println("An error occurred.");
                System.out.println("Try Again");
                e.printStackTrace();
            }
        }
    }
}
