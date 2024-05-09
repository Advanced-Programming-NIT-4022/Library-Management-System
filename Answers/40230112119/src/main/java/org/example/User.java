package org.example;

import java.util.ArrayList;

public class User {
    private String name;
    private int ID;
    private char[] phone;
    private String password;
    public User(String name, int ID, char[] phone, String password) {
        this.name = name;
        this.ID = ID;
        this.phone = phone;
        this.password = password;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public void setPhone(char[] phone) {
        this.phone = phone;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() { return name; }
    public int getID() { return ID; }
    public char[] getPhone() { return phone; }
    public String getPassword() { return password; }

    public void addBook(ArrayList<Book> booksList, String title, String author, String desc) {
        Book lastbook = booksList.get(booksList.size() - 1);
        int bookID = lastbook.getBookID();
        Book newBook = new Book(bookID, title, author, desc);
        booksList.add(newBook);
    }

}
