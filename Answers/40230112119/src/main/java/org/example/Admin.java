package org.example;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Admin extends User{
    private String password;
    public Admin(String name, int uniqueID, char[] phone, String password) {
        super(name, uniqueID, phone);
        this.password = password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() { return password; }
    public void removeBook(ArrayList<Book> booksList, String title) {
        for (int i = 0; i < booksList.size(); i++) {
            if (title.equals(booksList.get(i))) {
                booksList.remove(i);
                break;
            }
        }
    }
    public void addNewUser() {
        System.out.println("Enter the name of the user: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();

        Random id = new Random();
        int uniqueID = id.nextInt(9000) + 1000;

        boolean flag = true;
        char[] phone = null;
        do {
            System.out.println("Enter their phone number: ");
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

        Library m = new Library();
        int date = 2;
        m.newNormalUser(m.getUserList(), name, uniqueID, phone, date);
    }

    public void addAdmin(){

    }
}
