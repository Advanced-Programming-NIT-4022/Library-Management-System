package org.LMS;

import java.util.Date;

public class Rent {
    Integer id;
    Book book;
    User user;
    Date date;

    public Rent(Integer id, Book book, User user, Date date) {
        this.id = id;
        this.book = book;
        this.date = date;
        this.user = user;
    }
}
