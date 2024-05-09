package org.example;

import java.util.ArrayList;

public class User {
    private String name;
    private int uniqueID;
    private char[] phone;
    public User(String name, int uniqueID, char[] phone) {
        this.name = name;
        this.uniqueID = uniqueID;
        this.phone = phone;
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

    public void addBook(ArrayList<Book> booksList, String title, String author, String desc) {
        Book lastbook = booksList.get(booksList.size() - 1);
        int bookID = lastbook.getBookID();
        Book newBook = new Book(bookID, title, author, desc);
        booksList.add(newBook);
    }

}
