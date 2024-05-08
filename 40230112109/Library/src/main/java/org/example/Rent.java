package org.example;

import javax.xml.crypto.Data;
import java.util.Date;

public class Rent {
    // Attributes
    private Book book;
    private NormalUsers normalUsersormal;
    private String rentalID;
    private Date rentalDate;
    // Getters & Setters
    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public NormalUsers getNormalUsersormal() {
        return normalUsersormal;
    }

    public void setNormalUsersormal(NormalUsers normalUsersormal) {
        this.normalUsersormal = normalUsersormal;
    }

    public String getRentalID() {
        return rentalID;
    }

    public void setRentalID(String rentalID) {
        this.rentalID = rentalID;
    }

    public Date getRentalDate() {
        return rentalDate;
    }

    public void setRentalDate(Date rentalDate) {
        this.rentalDate = rentalDate;
    }
    // Constructor
}
