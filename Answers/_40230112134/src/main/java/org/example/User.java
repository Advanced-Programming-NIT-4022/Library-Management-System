package org.example;

import java.io.*;
import java.time.*;
import java.time.format.*;
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
            if (Objects.equals(book.getTitle(), list[1])  || Objects.equals(book.getDescription(), list[3]))
            {
                System.out.println("you can not add the book");
                System.out.println("because we have that");
            }
            else
            {
                setUniqueID(FindBigID(book.Total));
                book.Total.add(getUniqueIDINT() + "/" + book.getTitle() + "/" + book.getAuthor() + "/" + book.getDescription() + "/" + book.getAvailabilityStatus());
                WriteFileBook("Book.txt");
                System.out.println("The book has been successfully added");
                System.out.println("Your Unique ID is : " + getUniqueIDINT());
                break;
            }
        }
        if (book.Total.isEmpty()) {
            setUniqueID(1);
            book.Total.add(getUniqueIDINT() + "/" + book.getTitle() + "/" + book.getAuthor() + "/" + book.getDescription() + "/" + book.getAvailabilityStatus());
            WriteFileBook("Book.txt");
            System.out.println("The book has been successfully added");
            System.out.println("Your Unique ID is : " + getUniqueIDINT());
        }
    }
    public void SearchBook(String sentence)
    {
        boolean flag = false;
        ReadFileBook("Book.txt");
        char[] word = sentence.toCharArray();
        for (int i = 0; i < book.Total.size(); i++)
        {
            char[] jomle = book.Total.get(i).toCharArray();
            for (int j = 0; j < jomle.length; j++)
            {
                for (int k = 0; k < word.length; k++)
                {
                    if (word[k] == jomle[j])
                    {
                        flag = true;
                    }
                }
            }
            if (flag == true)
            {
                String[] list = book.Total.get(i).split("/");
                System.out.println("Your ID book: " + list[0]);
                System.out.println("Your Title: " + list[1]);
                System.out.println("Your Author: " + list[2]);
                System.out.println("Your Description: " + list[3]);
                System.out.println("Your Availability Status: " + list[4]);
            }
        }
        WriteFileBook("Book.txt");
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
                System.out.println("The deletion was successful");
                book.Total.remove(i);
            }
        }
        WriteFileBook("Book.txt");
    }
    public int FindBigID(ArrayList<String> total)
    {
        int bigerid = 0;
        for (int i = 0; i < total.size(); i++)
        {
            String[] list = total.get(i).split("/");
            char[] id = list[0].toCharArray();
            int[] numbersArray = new int[id.length];
            int[] numbers = new int[id.length];
            int x=0;
            for (int j = 0; j < id.length; j++)
            {
                numbersArray[j] = ((int) id[j])-48;
            }
            int c=1;
            for (int j = 0; j < id.length; j++)
            {
                 x += (numbersArray[j]*c);
                 c *= 10;
            }
            if (x > bigerid)
            {
                bigerid = x;
            }
        }
        return bigerid;
    }
}
class NormalUser extends User {

    LocalDateTime currentDateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private String formattedDateTime = currentDateTime.format(formatter);
    public NormalUser(String name, String phoneNumber) {
        super(name, phoneNumber);
    }
    public NormalUser() { super(); }
    public String getFormattedDateTime() { return formattedDateTime; }
}
class Admin extends User {
    private final String Password;
    public Admin(String name, String phonenumber)
    {
        super(name, phonenumber);
        this.Password = "8488";
    }
    public String getPassword() {return Password;}
}