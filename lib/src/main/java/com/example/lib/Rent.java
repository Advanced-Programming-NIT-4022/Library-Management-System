package com.example.lib;

import java.time.LocalDate;
import java.util.Random;

public class Rent {
    Random rand=new Random();
    public String getRentId() {
        return rentId;
    }

    public void setRentId(String rentId) {
        this.rentId = rentId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public User getUser() {
        return user;
    }

    public void setUser(normalUser user) {
        this.user = user;
    }

    public LocalDate getRentDate() {
        return rentDate;
    }

    public void setRentDate(LocalDate rentDate) {
        this.rentDate = rentDate;
    }

    private String rentId;
    private Book book;
    private User user;
    private LocalDate rentDate ;
    public Rent(Book book,User user){
        this.rentId= String.valueOf(rand.nextInt(9999));
        this.book=book;
        this.user=user;
        rentDate=LocalDate.now();
    }
    public Rent(){
        this.rentId= String.valueOf(rand.nextInt(9999));
        rentDate=LocalDate.now();

    }

}
