package org.example;

import java.util.Date;

public class MyApp {
        public static void main(String[] args) {

            Library library = new Library("My Library", 100, 9_5);

            Book book1 = new Book("Book2", 82734,"author1", "Description1");
            Book book2 = new Book("Book2", 23984,"author2", "Description2");
            library.addBook(book1);
            library.addBook(book2);

            NormalUser user1 = new NormalUser("User1", 1234567890,"09112143646", new Date());
            library.addUser(user1);


            library.rentBook(book1, user1, 1, new Date());
            library.returnBook(book1);
            library.removeUser(user1);
        }


    }
