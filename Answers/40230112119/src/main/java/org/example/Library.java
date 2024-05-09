package org.example;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Library {
    ArrayList<Book> booksList = new ArrayList<>();
    ArrayList<NormalUser> userList = new ArrayList<>();
    ArrayList<Admin> adminList = new ArrayList<>();

    public Library() {
        Admin firstAdmin = new Admin("Mahta", 1, "09036339284".toCharArray(), "1234");
        adminList.add(firstAdmin);
    }
    public ArrayList<NormalUser> getUserList() {
        return userList;
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
        int date = 1;
        newNormalUser(userList, name, uniqueID, phone, date);
    }
    public void login() {
        System.out.println("Welcome back! Enter your name:");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

    }
    public void newNormalUser(ArrayList<NormalUser> userList, String name,int uniqueID, char[] phone, int date) {
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
}
