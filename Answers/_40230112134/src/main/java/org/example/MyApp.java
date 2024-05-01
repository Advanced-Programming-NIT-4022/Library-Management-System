package org.example;

public class MyApp {
    public static void main(String[] args) {
        Book book = new Book();
//        book.AddBook();
        String mesal = book.SearchBook("1");
        System.out.println(mesal);
        book.Rent("525");
        String mesal1 = book.SearchBook("1");
        System.out.println(mesal1);
//        book.Delete("1");
    }

}