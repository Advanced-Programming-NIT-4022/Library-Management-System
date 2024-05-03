package com.library;

import com.library.Book;
import com.library.User;

import java.util.Date;

public class Rent {
    private User borrower;
    private Book book;
    private Date rentalDate;

    public Rent(User borrower, Book book) {
        this.borrower = borrower;
        this.book = book;
        this.rentalDate = new Date();
    }

}

