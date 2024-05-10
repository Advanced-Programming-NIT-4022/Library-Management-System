package org.example;

import java.io.Serializable;

public class Book implements Serializable {
    int bookId;
    String bookTitle, bookAuthor, bookDescription;
    boolean bookStatus= true;

    public Book(String bookTitle, int bookId, String bookAuthor, String bookDescription, boolean bookStatus){
        this.bookId = bookId;
        this.bookAuthor = bookAuthor;
        this.bookDescription = bookDescription;
        this.bookStatus= bookStatus;
    }
}
