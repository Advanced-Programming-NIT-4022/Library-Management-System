package com.Library;

public class Rent {
    private Book book ;
    private User user;
    private int rentalId;//آیدی برای اجاره کتاب که تکراری نشود!!!
    private String rentalDate; //مدت زمان rent

    private static int nextRentalID =1; // مقدار پیش فرض یا اولیه آیدی
    public Rent(Book book, User user, String rentalDate) {
        this.book = book;
        this.user = user;
        this.rentalId = nextRental;
        nextRental++;
        this.rentalDate = rentalDate;
    }
    public Book getBook(){
        return book;
    }
    public User getUser(){
        return rentalId;
    }
    public int getRentalId(){
        return rentalId;
    }
    public String getRentalDate() {
        return rentalDate;
     }
  }
