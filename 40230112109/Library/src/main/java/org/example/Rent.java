package org.example;

import javax.xml.crypto.Data;
import java.util.Date;

public class Rent {
    // Attributes
    private Book book;
    private NormalUsers normalUser;
    private boolean returned;
    private Date rentalDate;
    // Getters & Setters

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public NormalUsers getNormalUser() {
        return normalUser;
    }

    public void setNormalUser(NormalUsers normalUser) {
        this.normalUser = normalUser;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }
    //***** Methods *****//
    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    // Constructor

    public Rent(Book book, NormalUsers normalUser, Date rentalDate) {
        this.book = book;
        this.normalUser = normalUser;
        this.returned = false;
        this.rentalDate = rentalDate;
    }
}
