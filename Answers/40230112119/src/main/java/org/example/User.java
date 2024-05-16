package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private String name;
    private int uniqueID;
    private char[] phone;
    public User(String name, int uniqueID, char[] phone) {
        this.name = name;
        this.uniqueID = uniqueID;
        this.phone = phone;
    }
    public User() {
        this.name = "";
        this.uniqueID = -1;
        this.phone = "0".toCharArray();
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setUniqueID(int uniqueID) {
        this.uniqueID = uniqueID;
    }
    public void setPhone(char[] phone) {
        this.phone = phone;
    }

    public String getName() { return name; }
    public int getUniqueID() { return uniqueID; }
    public char[] getPhone() { return phone; }

    public boolean addBook(String[] cm) {
        Library lib = new Library();
        Scanner sc = new Scanner(System.in);
        for (Book j : lib.getBooksList()) {
            if (cm[3].equalsIgnoreCase(j.getTitle())) {
                if (cm[4].equalsIgnoreCase(j.getAuthor())) {
                    System.out.println("We already have that book. What do you want to do?" +
                            "\n1- Try another command\t\t\t2- Exit");
                    int choice = sc.nextInt();
                    if (choice == 1) {
                        return true;
                    } else {
                        break;
                    }
                }
            }
        }

        int bookID;
        if (lib.getBooksList().isEmpty()) {
            bookID = 1;
        }
        else {
            Book lastbook = lib.getBooksList().get(lib.getBooksList().size() - 1);
            bookID = lastbook.getBookID();
            bookID++;
        }
        Book newBook = new Book(bookID, cm[3], cm[4], cm[5]);
        lib.getBooksList().add(newBook);
        return false;
    }

}
