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
    public void ChapFileUser() {
        ReadFileNormalUser("NormalUser.txt");
        for (int i = 0; i < normalUser.getPeople().size(); i++)
        {
            String[] list = normalUser.getPeople().get(i).split("/");
            System.out.println("Name: " + list[1] + "Phone number: " + list[2] + "Time to enter the library: " + list[3]);
        }
    }
    public boolean ChapFileBook() {
        boolean flag = false;
        ReadFileNormalUser("Book.txt");
        for (int i = 0; i < normalUser.getPeople().size(); i++)
        {
            String[] list = normalUser.getPeople().get(i).split("/");
            System.out.println("Name: " + list[1] + "Author: " + list[2] + "AvailabilityStatus: " + list[4]);
            flag = true;
        }
        return flag;
    }

//    public void HomePage() {
//        System.out.println("Enter your way");
//        System.out.println("1. User");
//        System.out.println("2. Admin");
//        Scanner scanner = new Scanner(System.in);
//        int comment = scanner.nextInt();
//        boolean flag = true;
//        while (flag)
//        {
//            switch (comment)
//            {
//                case 1:
//
//                    break;
//                case 2:
//
//                    break;
//                default:
//                    System.out.println("try again");
//                    break;
//            }
//        }
//
//    }
    public void CLIComment() {
        boolean flag = true;
        while (flag) {
            System.out.println("1.lib add book");
            System.out.println("2.lib get hrs");
            System.out.println("3.lib rent book");
            System.out.println("4.lib get available books");
            System.out.println("5.lib return book");
            System.out.println("6.lib get available members");
            System.out.println("7.lib remove member");
            System.out.println("8.lib add member");
            System.out.println("9.exit");
            System.out.println("Enter your comment :");
            Scanner scanner = new Scanner(System.in);
            int comment = scanner.nextInt();
            switch (comment)
            {
                case 1:

                    CLIComment();
                    break;
                case 2:

                    CLIComment();
                    break;
                case 3:

                    CLIComment();
                    break;
                case 4:
                    boolean bb = getBookRepository();
                    if (!bb)
                    {
                        System.out.println("we do not have book");
                    }
                    CLIComment();
                    break;
                case 5:

                    CLIComment();
                    break;
                case 6:
                    ChapFileUser();
                    CLIComment();
                    break;
                case 7:

                    CLIComment();
                    break;
                case 8:

                    CLIComment();
                    break;
                case 9:
                    System.out.println("Bye Bye");
                    flag = false;
                    break;
                default:
                    System.out.println("Try again");
                    break;
            }
        }
    }
}
