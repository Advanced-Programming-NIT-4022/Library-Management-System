package org.example;

import java.io.*;
import java.time.*;
import java.time.format.*;
import java.util.*;

public class User extends UniqueID {
    Book book = new Book();
    private String Name;
    private String IDUser;
    private String PhoneNumber;
    private ArrayList<String> people = new ArrayList<>();
    public User(String name , String phoneNumber )
    {
        this.Name = name;
        this.PhoneNumber = phoneNumber;
        this.IDUser = getUniqueIDString();
    }
    public ArrayList<String> getPeople() { return people; }
    public void setPeople(ArrayList<String> people) { this.people = people; }
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
            setUniqueID(1);
            book.getTotal().add(book.getIDBook() + "/" + book.getTitle() + "/" + book.getAuthor() + "/" + book.getDescription() + "/" + book.getAvailabilityStatus());
            System.out.println("The book has been successfully added");
            System.out.println("Your Unique ID is : " + book.getIDBook());
        }
    }
    public void SearchBook(String sentence)
    {
        boolean flag = false;
        ReadFileBook("Book.txt");
        char[] word = sentence.toCharArray();
        for (int i = 0; i < book.getTotal().size(); i++)
        {
            char[] jomle = book.getTotal().get(i).toCharArray();
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
            if (flag)
            {
                flag = false;
                String[] list = book.getTotal().get(i).split("/");
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
        for (int i = 0; i < book.getTotal().size(); i++)
        {
            String line1 = book.getTotal().get(i);
            String[] list = line1.split("/");
            if (Objects.equals(list[0], number))
            {
                System.out.println("The deletion was successful");
                book.getTotal().remove(i);
                Rewind(i);
                break;
            }
        }
        book.setTotal(book.getTotal());
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
    public void Rewind(int num)
    {
        ArrayList<String> test = new ArrayList<>();
        for (int i = num; i < book.getTotal().size() ; i++)
        {
            String[] list = book.getTotal().get(i).split("/");
            int number = Integer.parseInt(list[0]) -1;
            list[0] = Integer.toString(number);
            String temp = list[0] + "/" + list[1] + "/" + list[2] + "/" + list[3] + "/" + list[4];
            test.add(temp);
        }
        for (int i = 0; i < book.getTotal().size(); i++)
        {
            book.getTotal().remove(num);
        }
        for (String s : test)
        {
            book.getTotal().add(s);
        }
    }
}
class NormalUser extends User {

    LocalDateTime currentDateTime = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private String UserDate;
    public NormalUser(String name, String phoneNumber) {
        super(name, phoneNumber);
        UserDate = currentDateTime.format(formatter);
    }
    public NormalUser() {
    }
    public String getFormattedDateTime() { return UserDate; }
}
class Admin extends User {
    private String Password;
    public Admin(String name, String phonenumber)
    {
        super(name, phonenumber);
        this.Password = "8488";
    }
    public Admin() {
    }
    public String getPassword() {return Password;}
}