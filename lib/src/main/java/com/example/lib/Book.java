package com.example.lib;

import java.util.Random;

public class Book {
    Random rand=new Random();
    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public boolean isAvailabilityStatus() {
        return AvailabilityStatus;
    }

    public Book(String title, String author, String description) {
        Title = title;
        Author = author;
        this.bookId= String.valueOf(rand.nextInt(9999));
        Description = description;
    }

    private String Title;
    private String Author;
    private String bookId;
    private String Description;
    private boolean AvailabilityStatus=true;

}
