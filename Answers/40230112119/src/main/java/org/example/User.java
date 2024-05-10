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

    public void addBook() {
        Library lib = new Library();
        Scanner sc = new Scanner(System.in);
        String title = null;
        String author = null;
        String desc = null;
        boolean flag = false;
        do {
            boolean book_found = false;
            System.out.println("Enter the name of the book: ");
            String inputTitle = sc.nextLine();
            System.out.println("Enter the author: ");
            String inputAuthor = sc.nextLine();
            System.out.println("Enter the description: ");
            String inputDesc = sc.nextLine();
            for (Book i : lib.getBooksList()) {
                if (i.getTitle().equalsIgnoreCase(inputTitle) && i.getAuthor().equalsIgnoreCase(inputAuthor)) {
                    book_found = true;
                    title = inputTitle;
                    author = inputAuthor;
                    desc = inputDesc;
                    break;
                }
            }
            if (!book_found) {
                System.out.println("We already have that book. Do you want to add something else?" +
                        "\n1- Yes\t\t\t2- No");
                int ans = sc.nextInt();
                sc.nextLine();
                if (ans == 1)
                    flag = false;
                else
                    flag = true;
            }
        } while (!flag);

        int bookID;
        if (lib.getBooksList().isEmpty()) {
            bookID = 1;
        }
        else {
            Book lastbook = lib.getBooksList().get(lib.getBooksList().size() - 1);
            bookID = lastbook.getBookID();
            bookID++;
        }
        Book newBook = new Book(bookID, title, author, desc);
        lib.getBooksList().add(newBook);
    }

}
