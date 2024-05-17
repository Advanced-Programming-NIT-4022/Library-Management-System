package org.example;

import java.io.*;
import java.util.*;

public class Library {
    NormalUser normalUser = new NormalUser();
    Admin admin = new Admin();
    User user = new User();
    private final String LibraryName;
    private final String OperatingHours;
    private final int CapacityBook;
    private final int CapacityUser;
//    private final boolean BookRepository;
    public Library(){
        this.LibraryName = "(-_-)(HOMA)(-_-)";
        this.OperatingHours =  "9 a.m. - 9 p.m.";
        this.CapacityBook = 50;
        this.CapacityUser = 25;
//        this.BookRepository = ChapFileBook();
    }
    public int getCapacityUser() { return CapacityUser; }
//    public boolean getBookRepository() { return BookRepository; }
    public int getCapacityBook() { return CapacityBook; }
    public String getOperatingHours() { return OperatingHours; }
    public String getLibraryName() {  return LibraryName; }
    public  void ReadFileNormalUser(String filepath) {
        normalUser.getPeople().clear();
        ArrayList<String> test = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath));
            String line;
            normalUser.getPeople().clear();
            while ((line = bufferedReader.readLine()) != null)
            {
                test.add(line);
            }
            bufferedReader.close();
        } catch (IOException r){
            System.out.println("An error occurred.");
        }
        normalUser.setPeople(test);
    }
    public void WriteFileNormalUser(String filepath) {
        try  {
            FileWriter writer = new FileWriter(filepath);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            for (String temp : normalUser.getPeople())
            {
                bufferedWriter.write(temp);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e){
            System.out.println("Wrong");
        }
    }
    public  void AddNormalUser(String studentID) {
//        ReadFileNormalUser("NormalUser.txt");
        normalUser.setIDUser(studentID);
        System.out.println("Enter the your name:");
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
            if (Objects.equals(normalUser.getName(), list[1]) || Objects.equals(normalUser.getPhoneNumber(), list[2]))
            {
                System.out.println("you can not add the user");
                System.out.println("because we have that");
            }
            else
            {
//                normalUser.setUniqueID(normalUser.FindBigID(normalUser.getPeople()));
                normalUser.getPeople().add(normalUser.getIDUser() + "/" + normalUser.getName() + "/" + normalUser.getPhoneNumber() + "/" + normalUser.getFormattedDateTime());
                System.out.println("The user has been successfully added");
                System.out.println("Your Unique ID is : " + normalUser.getIDUser());
                break;
            }
        }
        if (normalUser.getPeople().isEmpty()) {
            ArrayList<String> test = new ArrayList<>();
            test.add((normalUser.getIDUser()) + "/" + normalUser.getName() + "/" + normalUser.getPhoneNumber() + "/" + normalUser.getFormattedDateTime());
            normalUser.setPeople(test);
            System.out.println("The user has been successfully added");
            System.out.println("Your Unique ID is : " + normalUser.getIDUser());
        }
        WriteFileNormalUser("Normaluser.txt");
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
        for (int i = 0; i < normalUser.getPeople().size(); i++)
        {
            String[] list = normalUser.getPeople().get(i).split("/");
            System.out.println("ID: " + list[0] + "  _ Name: " + list[1] + "  _ Phone number: " + list[2] + "  _ Time to enter the library: " + list[3]);
        }
    }
    public void CLIComment() {
        user.ReadFileBook("Book.txt");
        ReadFileNormalUser("Normaluser.txt");
        while (true) {
            System.out.println(getLibraryName() +  "       How can I help you???!!!");
            System.out.println("lib add book <name> <author> <subtitle>");
            System.out.println("lib get hrs");
            System.out.println("lib rent <bookName>");
            System.out.println("lib add member <studentID> <password>");
            System.out.println("lib get available books");
            System.out.println("lib get available users <password>");
            System.out.println("7.lib remove member");
            System.out.println("8.lib add member");
            System.out.println("lib exit");
            System.out.println("Enter your comment:");
            Scanner scanner = new Scanner(System.in);
            String comment = scanner.nextLine();
            String[] list = comment.split(" ");
            if (Objects.equals(list[1], "add") && Objects.equals(list[2], "book"))
            {
                user.AddBook(list[3] , list[4] , list[5]);
            }
            else if (Objects.equals(list[1], "get") && Objects.equals(list[2], "hrs"))
            {
                System.out.println("**************************");
                System.out.println(getOperatingHours());
                System.out.println("**************************");
            }
            else if (Objects.equals(list[1], "exit")) {
//                System.exit(0);
                break;
            }
            else if (Objects.equals(list[1], "rent") && list.length <= 3)
            {
                Rent rent = new Rent();
                rent.RentBook(list[2]);
            }
            else if (Objects.equals(list[1], "add") && Objects.equals(list[2], "member"))
            {
                if (Objects.equals(list[4], admin.getPassword()))
                {
                    AddNormalUser(list[3]);
                }
            }
            else if (Objects.equals(list[1], "get") && Objects.equals(list[2], "available") && list.length == 3)
            {
                System.out.println("**************************");
                user.ChapFileBook();
                System.out.println("**************************");
            }
            else if (Objects.equals(list[1], "get") && Objects.equals(list[2], "available") && Objects.equals(list[4], admin.getPassword()))
            {

                System.out.println("**************************");
                ChapFileUser();
                System.out.println("**************************");
            }
//            switch (comment)
//            {
//                case "lib add book":
//                    if (BookCapacity <= getCapacityBook())
//                    {
//                        BookCapacity++;
//                        user.AddBook();
//                    }
//                    else
//                    {
//                        System.out.println("Sorry, we don't have room for books.");
//                        System.out.println("Try something else.");
//                    }
//                    CLIComment();
//                    break;
//                case 2:
//                    System.out.println(getOperatingHours());
//                    CLIComment();
//                    break;
//                case 3:
//                    Rent rent = new Rent();
//                    ChapFileBook();
//                    System.out.println("Enter your ID you want to rent: ");
//                    String testId =  scanner.nextLine();
//                    rent.RentBook(testId);
//                    CLIComment();
//                    break;
//                case 4:
//                    boolean bb = getBookRepository();
//                    if (!bb)
//                    {
//                        System.out.println("we do not have any books");
//                    }
//                    CLIComment();
//                    break;
//                case 5:
//
//                    CLIComment();
//                    break;
//                case 6:
//                    ChapFileUser();
//                    CLIComment();
//                    break;
//                case 7:
//                    String temp1 = scanner.nextLine();
//                    if (Objects.equals(temp1, admin.getPassword()))
//                    {
//                        ChapFileUser();
//                        System.out.println("Enter your ID you want delete : ");
//                        String testid = scanner.nextLine();
//                        DeleteNormalUser(testid);
//                    }
//                    else
//                    {
//                        System.out.println("Sorry,Try something else.");
//                    }
//                    CLIComment();
//                    break;
//                case 8:
//                    if (UserCapacity < getCapacityUser())
//                    {
//                        UserCapacity++;
//                        String temp = scanner.nextLine();
//                        if (Objects.equals(temp, admin.getPassword()))
//                        {
//                            AddNormalUser();
//                        }
//                        else
//                        {
//                            System.out.println("Sorry,Try something else.");
//                        }
//                    }
//                    else
//                    {
//                        System.out.println("Sorry, we don't have room for User");
//                        System.out.println("Try something else.");
//                    }
//                    CLIComment();
//                    break;
//                case 9:
//                    System.out.println("Bye Bye");
//                    System.exit(0);
//                    break;
//                default:
//                    System.out.println("Try again");
//                    break;
//            };
        }
        user.WriteFileBook("Book.txt");
        WriteFileNormalUser("Normaluser.txt");
    }
}