package org.example;

import java.util.ArrayList;

public class MyApp {
    public static void main(String[] args) {
        Book mine = new Book(1, "The", "mahta", "whatever");
        Library lib = new Library();
        lib.addBookElement(mine);
        NormalUser m = new NormalUser();
//        lib.signup();
//        System.out.println(lib.getUserList().size());
//        for(int i = 0; i < lib.getUserList().size(); i++) {
//            System.out.println(lib.getUserList().get(i).getName());
//            System.out.println(lib.getUserList().get(i).getPhone());
//        }
//        System.out.println(lib.getBooksList().get(0).getTitle());
        lib.homePage();
    }
}
