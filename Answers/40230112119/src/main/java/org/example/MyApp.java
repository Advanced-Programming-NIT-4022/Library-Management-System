package org.example;

import java.util.ArrayList;

public class MyApp {
    public static void main(String[] args) {
        Book mine = new Book(1, "The", "mahta", "whatever");
        Library lib = new Library();
        lib.addBookElement(mine);
        User u = new User();
        u.addBook();
    }
}
