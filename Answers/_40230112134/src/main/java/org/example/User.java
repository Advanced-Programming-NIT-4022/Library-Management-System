package org.example;

import java.io.*;
import java.time.*;
import java.time.format.*;
import java.util.*;

public class User extends UniqueID {
    Book book = new Book();
    Rent rent = new Rent();
    private String Name;
    private String IDUser;
    private String PhoneNumber;
    private ArrayList<String> people = new ArrayList<>();
    public ArrayList<String> getPeople() { return people; }
    public void setPeople(ArrayList<String> people) { this.people = people; }
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
            for (String temp : book.getTotal())
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
        ArrayList<String> test = new ArrayList<>();
        book.getTotal().clear();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath));
            String line;
            while ((line = bufferedReader.readLine()) != null)
            {
                test.add(line);
            }
            bufferedReader.close();
        } catch (IOException r){
            System.out.println("An error occurred.");
        }
        book.setTotal(test);
    }
    public void AddBook(String name , String author , String des)
    {
        book.setIDBook(String.valueOf(getUniqueIDInt() + 1));
        book.setTitle(name);
        book.setAuthor(author);
        book.setDescription(des);
        book.setAvailabilityStatus(true);
        for (int i = 0; i < book.getTotal().size(); i++)
        {
            String[] list = book.getTotal().get(i).split("/");
            if (Objects.equals(book.getTitle(), list[1])  || Objects.equals(book.getDescription(), list[3]))
            {
                System.out.println("you can not add the book");
                System.out.println("because we have that");
            }
            else
            {
//                setUniqueID(FindBigID(book.getTotal()));
                book.getTotal().add(book.getIDBook() + "/" + book.getTitle() + "/" + book.getAuthor() + "/" + book.getDescription() + "/" + book.getAvailabilityStatus());
                System.out.println("The book has been successfully added");
                System.out.println("Your Unique ID is : " + getUniqueIDInt());
                break;
            }
        }
        if (book.getTotal().isEmpty()) {
            setUniqueID(0);
            book.getTotal().add(book.getIDBook() + "/" + book.getTitle() + "/" + book.getAuthor() + "/" + book.getDescription() + "/" + book.getAvailabilityStatus());
            System.out.println("The book has been successfully added");
            System.out.println("Your Unique ID is : " + book.getIDBook());
        }
    }
    public void ChapFileBook()
    {
        for (int i = 0; i < book.getTotal().size(); i++)
        {
            String[] list = book.getTotal().get(i).split("/");
            if (Objects.equals(list[4], "true"))
            {
                System.out.println("ID: " + list[0] + "  _ Name: " + list[1] + "  _ Author: " + list[2] + "  _ AvailabilityStatus: " + list[4]);
            }
        }
    }
    public void SearchBook(String sentence)
    {
//        boolean flag = false;
//        ReadFileBook("Book.txt");
//        char[] word = sentence.toCharArray();
//        for (int i = 0; i < book.getTotal().size(); i++)
//        {
//            char[] jomle = book.getTotal().get(i).toCharArray();
//            for (int j = 0; j < jomle.length; j++)
//            {
//                for (int k = 0; k < word.length; k++)
//                {
//                    if (word[k] == jomle[j])
//                    {
//                        flag = true;
//                    }
//                }
//            }
//            if (flag)
//            {
//                flag = false;
//                String[] list = book.getTotal().get(i).split("/");
//                System.out.println("Your ID book: " + list[0]);
//                System.out.println("Your Title: " + list[1]);
//                System.out.println("Your Author: " + list[2]);
//                System.out.println("Your Description: " + list[3]);
//                System.out.println("Your Availability Status: " + list[4]);
//            }
//        }
//        WriteFileBook("Book.txt");
    }
    public void Delete(String number)
    {
//        for (int i = 0; i < book.getTotal().size(); i++)
//        {
//            String line1 = book.getTotal().get(i);
//            String[] list = line1.split("/");
//            if (Objects.equals(list[0], number))
//            {
//                System.out.println("The deletion was successful");
//                book.getTotal().remove(i);
//                break;
//            }
//        }
//        book.setTotal(book.getTotal());
    }
    public void Rent(String name)
    {
        for (int i = 0; i < book.getTotal().size(); i++)
        {
            String[] list = book.getTotal().get(i).split("/");
            if (Objects.equals(list[1],name))
            {
                if (Objects.equals(list[4],"true"))
                {
                    book.getTotal().remove(i);
                    System.out.println("The book has been successfully rented.");
                    System.out.println("enjoy , Bye.");
                    String test = list[0] + "/" + list[1] + "/" + list[2] + "/" + list[3] + "/" + rent.getRentalDate() ;
                    book.getTotal().add(test);
                    break;
                }
                else
                {
                    System.out.println("you can not rent this book because the book rented");
                }
            }
        }
    }
    public void ReturnBook(String name)
    {
        for (int i = 0; i < book.getTotal().size(); i++)
        {
            String[] list = book.getTotal().get(i).split("/");
            if (Objects.equals(list[1],name))
            {
                book.getTotal().remove(i);
                System.out.println("Thank you for returning the book");
                String test = list[0] + "/" + list[1] + "/" + list[2] + "/" + list[3] + "/" + "true" ;
                book.getTotal().add(test);
                break;
            }
        }
    }
}
class NormalUser extends User {

    LocalDateTime currentDateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private final String UserDate;
    public NormalUser() {
        UserDate = currentDateTime.format(formatter);
    }
    public String getFormattedDateTime() { return UserDate; }
}
class Admin extends User {
    private final String Password;
    public Admin()
    {
        this.Password = "8488";
    }
    public String getPassword() {return Password;}
}