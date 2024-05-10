package org.example;

import java.io.*;
import java.util.*;

public class Library {
    NormalUser normalUser = new NormalUser();
    Admin admin = new Admin();
    User user;
    private final String LibraryName;
    private final String OperatingHours;
    private final int Capacity;
    private final boolean BookRepository;
    public Library(){
        user = new User();
        this.LibraryName = "HOMA";
        this.OperatingHours =  "9 a.m. - 9 p.m.";
        this.Capacity = 25;
        this.BookRepository = ChapFileBook();
    }
    public boolean getBookRepository() { return BookRepository; }
    public int getCapacity() { return Capacity; }
    public String getOperatingHours() { return OperatingHours; }
    public String getLibraryName() {  return LibraryName; }
    public  void ReadFileNormalUser(String filepath) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath));
            String line;
            user.getPeople().clear();
            while ((line = bufferedReader.readLine()) != null)
            {
                user.getPeople().add(line);
            }
            bufferedReader.close();
        } catch (IOException r){
            System.out.println("An error occurred.");
        }
        user.setPeople(user.getPeople());
    }
    public void WriteFileNormalUser(String filepath) {
        try  {
            FileWriter writer = new FileWriter(filepath);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (String temp : user.getPeople())
            {
                bufferedWriter.write(temp);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e){
            System.out.println("Wrong");
        }
        user.getPeople().clear();
    }
    public  void AddNormalUser() {
        ReadFileNormalUser("NormalUser.txt");
        System.out.println("Enter the your name");
        Scanner scanner = new Scanner(System.in);
        normalUser.setName(scanner.nextLine());
        boolean flag = true;
        while (flag)
        {
            System.out.println("Enter your phone number");
            String temp = scanner.nextLine();
            char[] tem = temp.toCharArray();
            for (char c : tem)
            {
                if (c < 48 || c > 57)
                {
                    System.out.println("You entered incorrectly\n" + "try again:");
                    break;
                }
                else
                {
                    flag = false;
                    normalUser.setPhoneNumber(temp);
                }
            }
        }
        for (int i = 0; i < normalUser.getPeople().size(); i++)
        {
            String[] list = normalUser.getPeople().get(i).split("/");
            if (Objects.equals(normalUser.getName(), list[1])  || Objects.equals(normalUser.getPhoneNumber(), list[2]))
            {
                System.out.println("you can not add the user");
                System.out.println("because we have that");
            }
            else
            {
                normalUser.setUniqueID(normalUser.FindBigID(normalUser.getPeople()));
                normalUser.getPeople().add((normalUser.getIDUser()) + "/" + normalUser.getName() + "/" + normalUser.getPhoneNumber() + normalUser.getFormattedDateTime());
                System.out.println("The user has been successfully added");
                System.out.println("Your Unique ID is : " + normalUser.getIDUser());
                break;
            }
        }
        if (normalUser.getPeople().isEmpty()) {
            normalUser.setUniqueID(1);
            normalUser.getPeople().add((normalUser.getIDUser()) + "/" + normalUser.getName() + "/" + normalUser.getPhoneNumber() + normalUser.getFormattedDateTime());
            System.out.println("The user has been successfully added");
            System.out.println("Your Unique ID is : " + normalUser.getIDUser());
        }
        WriteFileNormalUser("NormalUser.txt");
    }
    public void DeleteNormalUser(String number) {
        ReadFileNormalUser("NormalUser.txt");
        for (int i = 0; i < normalUser.getPeople().size(); i++)
        {
            String line1 = normalUser.getPeople().get(i);
            String[] list = line1.split("/");
            if (Objects.equals(list[0], number))
            {
                System.out.println("The deletion was successful");
                normalUser.getPeople().remove(i);
                break;
            }
        }
        normalUser.setPeople(normalUser.getPeople());
    }
    private boolean ChapFileBook() {
        boolean flag = false;
        ReadFileNormalUser("NormalUser.txt");
        for (int i = 0; i < normalUser.getPeople().size(); i++)
        {
            String[] list = normalUser.getPeople().get(i).split("/");
            System.out.println("Name: " + list[1] + "Phone number: " + list[2] + "Time to enter the library: " + list[3]);
            flag = true;
        }
        return flag;
    }
    public void CLIComment()
    {
        boolean flag = true;
        while (flag) {
            System.out.println("lib add book");
            System.out.println("lib get hrs");
            System.out.println("lib rent book");
            System.out.println("lib add member");
            System.out.println("lib rent");
            System.out.println("lib get available books");
            System.out.println("lib remove member");
            System.out.println("lib return book");
            System.out.println("Enter your comment :");
            Scanner scanner = new Scanner(System.in);
            String comment = scanner.nextLine();
            switch (comment) {
                case "lib add book":

                    CLIComment();
                    break;
                case "lib get hrs":

                    break;
                case "lib rent book":

                    break;
                case "lib add member":

                    break;
                case "lib get available books":

                    break;
                case "lib remove member":

                    break;
                case "lib return book":

                    break;
                case "exit":
                    flag = false;
                    break;
                default:
                    System.out.println("please enter again");
                    break;
            }
        }
    }
}
