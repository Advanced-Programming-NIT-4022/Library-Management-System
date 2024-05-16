package org.example;

import java.util.Date;

public class Rent {
    public void setBook(Book book) {
        this.book = book;
    }

    public void setNormalUser(NormalUser normalUser) {
        this.normalUser = normalUser;
    }

    public void setRentalID(int rentalID) {
        this.rentalID = rentalID;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }

    private Book book;
    private NormalUser normalUser;
    private int rentalID;

    public Book getBook() {
        return book;
    }

    public NormalUser getNormalUser() {
        return normalUser;
    }

    public int getRentalID() {
        return rentalID;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    private Date rentalDate;
    public Rent (Book book, NormalUser normalUser, int rentalID, Date rentalDate)
    {
        this.book = book;
        this.normalUser= normalUser;
        this.rentalID = rentalID;
        this.rentalDate= rentalDate;
    }




}
