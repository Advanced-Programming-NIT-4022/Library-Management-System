package org.example;

import java.util.UUID;
//***** Attributes *****//
public class Book {
    private String bookID;
    private String title;
    private String author;
    private String description;
    private boolean availability;

    // Constructor
    Book(String title, String author, String description){
        this.title = title;
        this.author = author;
        this.description = description;
        this.bookID = generateUniqueId();
        this.availability = true;
    }
    // Getters and Setters

    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public static String generateUniqueId(){
        return UUID.randomUUID().toString();
    }
}
