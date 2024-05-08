package org.example;

import java.util.*;

public class MyApp {
    public static void main(String[] args) {
        Book book = new Book();
        book.AddBook();
        book.AddBook();
//        book.AddBook();
        book.Rent("59");
        book.Rent("91");
        book.Delete("96");
        book.SearchBook("amir");
//        book.SearchBook("e");
//        book.SearchBook("a");
    }

}