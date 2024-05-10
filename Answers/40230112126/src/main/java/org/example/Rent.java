package org.example;

import java.io.Serializable;

public class Rent implements Serializable {
    Book bookObj;
    User userObj;
    int rentalId;
    String rentalDate;

    Rent(int rentalId , String rentalDate , Book bookObj, User userObj){
        this.rentalDate = rentalDate;
        this.rentalId = rentalId;
        this.bookObj = bookObj;
        this.userObj = userObj;
    }
}
