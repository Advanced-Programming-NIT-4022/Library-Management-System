package org.example;

public class MyApp {
    public static void main(String[] args) {
        Book book = new Book();
//        book.AddBook();
        boolean mesal = book.SearchBook("38");
        System.out.println(mesal);
    }

}