package org.example;

import java.util.HashMap;

public class Book {
    private int Unique_bookID;
    private String title;
    private String author;
    private boolean Availability_status;
    String Description;

    public int getUnique_bookID() {
        return Unique_bookID;
    }

    public void setUnique_bookID(int unique_bookID) {
        Unique_bookID = unique_bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailability_status() {
        return Availability_status;
    }

    public void setAvailability_status(boolean availability_status) {
        Availability_status = availability_status;
    }


    public Book (String title, int bookID, String author, String description) {
        Unique_bookID = bookID;
        this.title = title;
        this.author = author;
        this.Availability_status = true;
        this.Description= description;
    }
}

