package org.example;

import java.util.ArrayList;

public class MyApp {
    public static void main(String[] args) {
        Book mine = new Book(1, "The", "mahta", "whatever");
        Library lib = new Library();
//        NormalUser m = new NormalUser();
//        lib.signup();
//        System.out.println(lib.getUserList().size());
//        for(int i = 0; i < lib.getUserList().size(); i++) {
//            System.out.println(lib.getUserList().get(i).getName());
//            System.out.println(lib.getUserList().get(i).getPhone());
//        }
        lib.homePage();
    }
}
