package org.example;

import java.util.ArrayList;

public class MyApp {
    public static void main(String[] args) {
        Book mine = new Book(1, "Dorian", "Wilde", "whatever");
        Library lib = new Library();
        lib.addBookElement(mine);
        NormalUser p1 = new NormalUser("Harry", 8765, "09033457685", "2020.03.04  12:34");
        lib.addUserElement(p1);
        Admin owner = new Admin("Mahta", 1234, "09036339284", "1234");
        lib.addAdminElement(owner);

        lib.homePage();
    }
}
