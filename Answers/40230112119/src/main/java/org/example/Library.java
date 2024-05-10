package org.example;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Library {
    private final String operatingHours = "From 8 A.M. to 6 P.M.";
    private ArrayList<Book> booksList = new ArrayList<>();
    private ArrayList<NormalUser> userList = new ArrayList<>();
    private ArrayList<Admin> adminList = new ArrayList<>();

    public void addBookElement(Book obj) {
        booksList.add(obj);
    }
    public void addUserElement(NormalUser obj) {
        userList.add(obj);
    }

    public Library() {
        Admin owner = new Admin("Mahta", 1234, "09036339284".toCharArray(), "1234");
        adminList.add(owner);
    }

    public String getOperatingHours() {
        return operatingHours;
    }

    public ArrayList<Book> getBooksList() {
        return booksList;
    }

    public ArrayList<NormalUser> getUserList() {
        return userList;
    }

    public ArrayList<Admin> getAdminList() {
        return adminList;
    }

    public void signup() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = sc.nextLine();
        boolean flag = true;
        char[] phone = null;
        do {
            System.out.println("Enter your phone: ");
            String input = sc.nextLine();
            char[] tmp = input.toCharArray();
            for (char i : tmp) {
                int ascii = (int) i;
                if (ascii < 48 || ascii > 57) {
                    System.out.println("Invalid number. Try again.");
                    flag = false;
                    break;
                }
                else {
                    flag = true;
                    phone = tmp;
                }
            }
        } while (!flag);
        Random id = new Random();
        int uniqueID = id.nextInt(9000) + 1000;
        System.out.println("Welcome " + name + "! Here is your unique ID: " + uniqueID);
        int date = 1;
        newNormalUser(userList, name, uniqueID, phone, date);
    }
    public void login(boolean isUser) {
        System.out.println("Welcome back! Enter your name:");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

    }
    public void newNormalUser(ArrayList<NormalUser> userList, String name, int uniqueID, char[] phone, int date) {
        int userID;
        if (userList.isEmpty()) {
            userID = 1;
        }
        else {
            User lastUser = userList.get(userList.size() - 1);
            userID = lastUser.getUniqueID();
            userID++;
        }
        NormalUser newUser = new NormalUser(name, uniqueID, phone, date);
        userList.add(newUser);
    }
    public void homePage() {
        System.out.println("Welcome to our library! Please sign up or log in.");
        System.out.println("1- Sign Up\t\t\t2- Log In");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch(choice) {
            case 1:
                signup();
                break;
            case 2:
                System.out.println("Choose your position.\n1- User\t\t\t2- Admin");
                int pos = sc.nextInt();
                boolean isUser = true;
                switch(pos) {
                    case 1:
                        login(isUser);
                        break;
                    case 2:
                        isUser = false;
                        login(isUser);
                        break;
                }
        }


    }
}
